package com.example.tatarkanovkantemir.presentation.fragments.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tatarkanovkantemir.databinding.FragmentFavoriteMoviesBinding
import com.example.tatarkanovkantemir.presentation.fragments.movies.MoviesAdapter

class FavoriteMoviesFragment : Fragment() {

    private lateinit var favoritesRecyclerView: RecyclerView
    private var viewBinding: FragmentFavoriteMoviesBinding? = null
    private val binding get() = viewBinding!!
    private val adapter = FavoriteMoviesAdapter()
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentFavoriteMoviesBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this)[FavoriteMoviesViewModel::class.java]
        favoritesRecyclerView = binding.recyclerView
        favoritesRecyclerView.adapter = adapter
        favoritesRecyclerView.layoutManager = LinearLayoutManager(context)
        viewModel.getMovies().observe(viewLifecycleOwner){
            adapter.setList(it)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

}