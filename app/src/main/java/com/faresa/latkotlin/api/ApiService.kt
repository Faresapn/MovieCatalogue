package com.faresa.latkotlin.api

import com.faresa.latkotlin.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getPopular(
        @Query ("api_key")apiKey:String,
        @Query("page")page:Int
    ): Call<MovieResponse>
}