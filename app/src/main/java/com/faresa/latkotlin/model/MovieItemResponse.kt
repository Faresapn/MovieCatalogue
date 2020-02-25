package com.faresa.latkotlin.model

import android.icu.text.CaseMap
import com.google.gson.annotations.SerializedName

data class MovieItemResponse (
    @SerializedName("poster_path")
    val poster_path:String,
    @SerializedName("title", alternate = ["name"])
    val title:String

)



