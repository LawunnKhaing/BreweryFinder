package com.example.qtquickview_kotlin

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object BreweryService {
    private const val BASE_URL = "https://api.openbrewerydb.org/v1/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(BreweryApi::class.java)

    suspend fun fetchNorthernMostBrewery(): Brewery? {
        return api.getBreweriesByDistance("55.0, -7.0").firstOrNull() ?: Brewery("N/A", "Unknown", null, null, "Ireland")
    }

    suspend fun fetchSouthernMostBrewery(): Brewery? {
        return api.getBreweriesByDistance("51.0, -9.0").firstOrNull() ?: Brewery("N/A", "Unknown", null, null, "Ireland")
    }

    suspend fun fetchLongestNameBrewery(): Brewery? {
        return api.getLongestNameBrewery().maxByOrNull { it.name.length } ?: Brewery("N/A", "Unknown", null, null, "Ireland")
    }
}
