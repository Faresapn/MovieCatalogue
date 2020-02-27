package com.faresa.latkotlin.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.faresa.latkotlin.R
import com.faresa.latkotlin.adapter.Adapter
import com.faresa.latkotlin.adapter.AdapterUpComing
import com.faresa.latkotlin.model.MovieItemResponse
import com.faresa.latkotlin.model.MovieUpcomingResponse
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {


    private lateinit var viewModel: MovieViewModel
    private lateinit var adapter: Adapter
    private lateinit var adapterup: AdapterUpComing
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

        viewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        viewModel.initUp(1)
        viewModel.getDataUpcoming().observe(viewLifecycleOwner, Observer { movieUp->
            getinitUp(movieUp)
        })

        return root
    }

    private fun getinitUp(list: List<MovieUpcomingResponse>) {
        rvUpComing.apply { layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,true)
            adapterup = AdapterUpComing(list)
            rvUpComing.adapter = adapterup
        }


    }

    private fun getinit(list: List<MovieItemResponse>) {
        rv.apply { layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,true)
            adapter = Adapter(list)
            rv.adapter = adapter
        }

    }
}
