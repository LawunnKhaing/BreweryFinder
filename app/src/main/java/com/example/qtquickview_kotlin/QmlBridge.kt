package com.example.qtquickview_kotlin

import android.util.Log
import kotlinx.coroutines.*

class QmlBridge(private val activity: MainActivity) {
    private val scope = CoroutineScope(Dispatchers.Main)

    fun fetchBreweryData() {
        scope.launch {
            try {
                val northernMost = withContext(Dispatchers.IO) { BreweryService.fetchNorthernMostBrewery() }
                val southernMost = withContext(Dispatchers.IO) { BreweryService.fetchSouthernMostBrewery() }
                val longestName = withContext(Dispatchers.IO) { BreweryService.fetchLongestNameBrewery() }

                val northernName = northernMost?.name ?: "Unknown Brewery"
                val southernName = southernMost?.name ?: "Unknown Brewery"
                val longestNameBrewery = longestName?.name ?: "Unknown Brewery"

                Log.d("QmlBridge", "Fetched Breweries: $northernName, $southernName, $longestNameBrewery")

                activity.runOnUiThread {
                    activity.updateQmlData(northernName, southernName, longestNameBrewery)
                }
            } catch (e: Exception) {
                Log.e("QmlBridge", "Error fetching brewery data: ${e.message}")
            }
        }
    }
}
