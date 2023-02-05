package com.example.tatarkanovkantemir.presentation.fragments.movies

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.tatarkanovkantemir.data.RetrofitRepository
import com.example.tatarkanovkantemir.data.room.MoviesDB
import com.example.tatarkanovkantemir.data.room.MoviesRepositoryImpl
import com.example.tatarkanovkantemir.model.Film
import com.example.tatarkanovkantemir.model.MovieDetails
import com.example.tatarkanovkantemir.model.MoviesModel
import com.example.tatarkanovkantemir.utils.ROOM_REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response


class MoviesFragmentViewModel(app: Application) : AndroidViewModel(app) {

    val movies: MutableLiveData<Response<MoviesModel>> = MutableLiveData()
    private val retrofitRepository = RetrofitRepository()
    val context = app

    fun getMovies() {
        viewModelScope.launch {
            movies.value = retrofitRepository.getMovies()
        }
    }

    fun dbInitial() {
        val dao = MoviesDB.instance(context).getMoviesDao()
        ROOM_REPOSITORY = MoviesRepositoryImpl(dao)
    }

    fun insert(film: Film, onSuccess: () -> Unit) =
        viewModelScope.launch (Dispatchers.IO){
            ROOM_REPOSITORY.insertMovie(film){
                onSuccess()
            }
        }

    fun delete(film: Film, onSuccess: () -> Unit) =
        viewModelScope.launch (Dispatchers.IO){
            ROOM_REPOSITORY.deleteMovie(film){
                onSuccess()
            }
        }

}