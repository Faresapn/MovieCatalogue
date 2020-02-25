package com.faresa.latkotlin.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.faresa.latkotlin.R
import com.faresa.latkotlin.adapter.Adapter
import com.faresa.latkotlin.model.MovieItemResponse
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {


    private lateinit var viewModel: MovieViewModel
    private lateinit var adapter: Adapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_movie, container, false)
        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        viewModel.init(1)
        viewModel.getData().observe(viewLifecycleOwner, Observer { movie->
            getinit(movie)
        })
        return root
    }
    private fun getinit(list: List<MovieItemResponse>) {
        adapter = Adapter(list)
        rv.adapter = adapter
    }
}
