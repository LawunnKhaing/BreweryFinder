package com.example.qtquickview_kotlin

import retrofit2.http.GET
import retrofit2.http.Query

/*interface BreweryApi {
    @GET("breweries")
    suspend fun getBreweriesByDistance(
        @Query("by_dist") byDist: String, // Requires latitude,longitude
        @Query("per_page") perPage: Int = 1 // Get only one brewery
    ): List<Brewery> // The API returns a list, not a single object

    @GET("breweries")
    suspend fun getLongestNameBrewery(
        @Query("per_page") perPage: Int = 200 // Get more results
    ): List<Brewery>
}*/


interface BreweryApi {
    @GET("breweries")
    suspend fun getNorthernMostBrewery(
        @Query("by_country") country: String,
        @Query("per_page") perPage: Int = 50
    ): List<Brewery>

    @GET("breweries")
    suspend fun getSouthernMostBrewery(
        @Query("by_country") country: String,
        @Query("per_page") perPage: Int = 50
    ): List<Brewery>

    @GET("breweries")
    suspend fun getLongestNameBrewery(
        @Query("by_country") country: String,
        @Query("per_page") perPage: Int = 50
    ): List<Brewery>
}
