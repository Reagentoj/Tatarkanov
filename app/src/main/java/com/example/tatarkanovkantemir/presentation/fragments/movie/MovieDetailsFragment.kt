package com.example.tatarkanovkantemir.presentation.fragments.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tatarkanovkantemir.R
import com.example.tatarkanovkantemir.databinding.FragmentMovieDetailsBinding
import com.example.tatarkanovkantemir.utils.*
import com.squareup.picasso.Picasso

class MovieDetailsFragment : Fragment() {

    private var viewBinding: FragmentMovieDetailsBinding? = null
    private val binding get() = viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var bundle = this.arguments
        viewBinding = FragmentMovieDetailsBinding.inflate(layoutInflater, container, false)
        if (arguments != null) {
            CURRENT_MOVIE_NAME = bundle?.getString("title").toString()
            CURRENT_MOVIE_GENRE = bundle?.getString("genre").toString()
            CURRENT_MOVIE_COUNTRY = bundle?.getString("country").toString()
            CURRENT_MOVIE_POSTER = bundle?.getString("poster").toString()
            CURRENT_MOVIE_ID = bundle?.getInt("id")!!
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[MovieDetailsViewModel::class.java]
        viewModel.getMovieDetails(MOVIE_ID)

        binding.title.text = CURRENT_MOVIE_NAME
        binding.genre.text = CURRENT_MOVIE_GENRE
        binding.country.text = CURRENT_MOVIE_COUNTRY
        Picasso.with(context)
            .load(CURRENT_MOVIE_POSTER)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
            .into(binding.poster)
        viewModel.movieDetails.observe(viewLifecycleOwner) {
            binding.description.text = it.body()!!.description

        }
    }


}