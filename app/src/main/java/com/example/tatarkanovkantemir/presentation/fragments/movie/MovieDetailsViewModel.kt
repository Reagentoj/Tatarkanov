package com.example.tatarkanovkantemir.presentation.fragments.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tatarkanovkantemir.data.RetrofitRepository
import com.example.tatarkanovkantemir.model.MovieDetails
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class MovieDetailsViewModel : ViewModel() {
    val movieDetails: MutableLiveData<Response<MovieDetails>> = MutableLiveData()
    private val retrofitRepository = RetrofitRepository()


    fun getMovieDetails(movieId: Int) {
        viewModelScope.launch {
            movieDetails.value = retrofitRepository.getMovieDetail(movieId)
        }
    }

}