package com.faresa.latkotlin.model

import com.google.gson.annotations.SerializedName

data class MovieUpcome (
        @SerializedName("page")
        val page:Int,
        @SerializedName("results")
        val result: ArrayList<MovieUpcomingResponse>
)
