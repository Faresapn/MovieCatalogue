package com.faresa.latkotlin.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.faresa.latkotlin.BuildConfig
import com.faresa.latkotlin.R
import com.faresa.latkotlin.model.MovieItemResponse
import com.faresa.latkotlin.model.MovieUpcomingResponse
import kotlinx.android.synthetic.main.items.view.*
import kotlinx.android.synthetic.main.items.view.poster
import kotlinx.android.synthetic.main.items.view.tittle
import kotlinx.android.synthetic.main.items_upcoming.view.*

class AdapterUpComing (val list : List<MovieUpcomingResponse>): RecyclerView.Adapter<AdapterUpComing.MovieViewHolder>() {
    class MovieViewHolder(val view: View) : RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.items_upcoming,
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        Glide.with(holder.view).load(BuildConfig.IMAGE_URL + list[position].poster_path)
            .into(holder.view.poster)
        Log.d("image", BuildConfig.IMAGE_URL + list[position].poster_path)
        holder.view.release.text = list[position].release_date
        holder.view.tittle.text = list[position].title
    }
}