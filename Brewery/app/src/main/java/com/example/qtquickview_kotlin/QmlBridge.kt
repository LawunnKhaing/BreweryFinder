package com.example.qtquickview_kotlin

import android.util.Log
import kotlinx.coroutines.*

class QmlBridge(private val activity: MainActivity) {

    private val scope = CoroutineScope(Dispatchers.Main)

    fun fetchBreweryData() {
        scope.launch {
            activity.updateTitleText("Fetching Brewery Data...") // ✅ Use function instead of accessing binding

            try {
                val northernMost = withContext(Dispatchers.IO) { BreweryService.fetchNorthernMostBrewery() }
                val southernMost = withContext(Dispatchers.IO) { BreweryService.fetchSouthernMostBrewery() }
                val longestName = withContext(Dispatchers.IO) { BreweryService.fetchLongestNameBrewery() }

                Log.d("QmlBridge", "Fetched Breweries: ${northernMost?.name}, ${southernMost?.name}, ${longestName?.name}")

                activity.runOnUiThread {
                    activity.updateQmlData(
                        northernMost?.let { formatBreweryData(it) } ?: "Not Found",
                        southernMost?.let { formatBreweryData(it) } ?: "Not Found",
                        longestName?.let { formatBreweryData(it) } ?: "Not Found"
                    )
                    activity.updateTitleText("Breweries List Fetched ✅") // ✅ Update title text safely
                }

            } catch (e: Exception) {
                Log.e("QmlBridge", "Error fetching brewery data: ${e.message}")
                activity.updateTitleText("Failed to fetch breweries ❌") // ✅ Show error message safely
            }
        }
    }

    private fun formatBreweryData(brewery: Brewery): String {
        return "${brewery.name}\n${brewery.city}, ${brewery.country}\n(${brewery.latitude}, ${brewery.longitude})"
    }
}
