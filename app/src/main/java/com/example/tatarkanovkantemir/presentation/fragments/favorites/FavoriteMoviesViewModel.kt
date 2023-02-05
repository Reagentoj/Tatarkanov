package com.example.tatarkanovkantemir.presentation.fragments.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.tatarkanovkantemir.model.Film
import com.example.tatarkanovkantemir.utils.ROOM_REPOSITORY

class FavoriteMoviesViewModel : ViewModel() {

    fun getMovies(): LiveData<List<Film>> {
        return ROOM_REPOSITORY.movies
    }
}