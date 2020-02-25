package com.faresa.latkotlin.model

import com.google.gson.annotations.SerializedName

data class MovieResponse (
    @SerializedName("page")
     val page:Int,
    @SerializedName("results")
    val result: ArrayList<MovieItemResponse>
)