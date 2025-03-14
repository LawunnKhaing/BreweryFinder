package com.example.qtquickview_kotlin

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BreweryApiService {
    @GET("breweries")
    fun getBreweriesInIreland(
        @Query("by_country") country: String = "Ireland",
        @Query("per_page") perPage: Int = 50
    ): Call<List<Brewery>>
}
