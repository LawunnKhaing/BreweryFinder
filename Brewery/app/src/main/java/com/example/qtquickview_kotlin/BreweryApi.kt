package com.example.qtquickview_kotlin

import retrofit2.http.GET
import retrofit2.http.Query
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
