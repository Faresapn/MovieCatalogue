package com.faresa.latkotlin.api

import android.os.Debug
import com.faresa.latkotlin.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Client {
    private fun  getClient():Retrofit{
        val intereceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG)intereceptor.level = HttpLoggingInterceptor.Level.BODY
        val client:OkHttpClient = OkHttpClient.Builder().addInterceptor(intereceptor).
            connectTimeout(30,TimeUnit.SECONDS).
            readTimeout(30,TimeUnit.SECONDS).
            writeTimeout(30,TimeUnit.SECONDS).
            build()
        return  Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
   /* fun client():OkHttpClient{
        val intereceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG)intereceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(intereceptor).
            connectTimeout(30,TimeUnit.SECONDS).
            readTimeout(30,TimeUnit.SECONDS).
            writeTimeout(30,TimeUnit.SECONDS).
            build()
    }*/


    fun getApi():ApiService{
        return getClient().create(ApiService::class.java)
    }
}