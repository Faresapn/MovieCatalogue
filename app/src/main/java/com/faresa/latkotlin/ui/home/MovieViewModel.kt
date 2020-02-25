package com.faresa.latkotlin.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.faresa.latkotlin.BuildConfig
import com.faresa.latkotlin.api.Client
import com.faresa.latkotlin.model.MovieItemResponse
import com.faresa.latkotlin.model.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MovieViewModel() :ViewModel(){

    fun init(page: Int){
        getPopular(page)
    }

    private val data = MutableLiveData<List<MovieItemResponse>>()
     fun getPopular(page:Int){
        Client().getApi().getPopular(BuildConfig.API_KEY,page).enqueue(object : Callback<MovieResponse>{
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("failure", t.toString())
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
               if(response.isSuccessful){
                   val respon: MovieResponse? = response.body()
                   data.postValue(respon?.result)
               }
            }

        })

     }
      fun getData(): LiveData<List<MovieItemResponse>> {
          return data
      }


}