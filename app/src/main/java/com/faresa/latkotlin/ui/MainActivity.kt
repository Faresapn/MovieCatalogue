package com.faresa.latkotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.faresa.latkotlin.R
import com.faresa.latkotlin.adapter.Adapter
import com.faresa.latkotlin.model.MovieItemResponse
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MovieViewModel
    private lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        viewModel.init(1)
        viewModel.getData().observe(this, Observer { movie->
           getinit(movie)
        })
    }

    private fun getinit(list: List<MovieItemResponse>) {
        adapter = Adapter(list)
        rv.adapter = adapter

    }
}
