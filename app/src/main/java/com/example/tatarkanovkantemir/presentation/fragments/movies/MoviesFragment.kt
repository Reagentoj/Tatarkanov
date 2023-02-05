package com.example.tatarkanovkantemir.presentation.fragments.movies

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tatarkanovkantemir.R
import com.example.tatarkanovkantemir.databinding.FragmentMoviesBinding
import com.example.tatarkanovkantemir.model.Film
import com.example.tatarkanovkantemir.utils.*


class MoviesFragment : Fragment() {

    private lateinit var moviesRecyclerView: RecyclerView
    private var viewBinding: FragmentMoviesBinding? = null
    private val binding get() = viewBinding!!
    private val adapter = MoviesAdapter()
    lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        init()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.favorite_movies, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.favoriteMovies -> navController.navigate(R.id.favoriteMoviesFragment)
        }
        return super.onOptionsItemSelected(item)
    }


    private fun init() {
        val viewModel = ViewModelProvider(this)[MoviesFragmentViewModel::class.java]
        MOVIES_FRAGMENT_VIEWMODEL = viewModel
        viewModel.getMovies()
        viewModel.dbInitial()
        moviesRecyclerView = binding.moviesRecyclerView
        moviesRecyclerView.adapter = adapter
        moviesRecyclerView.layoutManager = LinearLayoutManager(context)
        viewModel.movies.observe(viewLifecycleOwner) {
            adapter.setList(it.body()!!.films)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

}