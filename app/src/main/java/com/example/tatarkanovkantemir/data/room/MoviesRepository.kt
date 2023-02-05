package com.example.tatarkanovkantemir.data.room

import androidx.lifecycle.LiveData
import com.example.tatarkanovkantemir.model.Film

interface MoviesRepository {
    val movies: LiveData<List<Film>>
    suspend fun insertMovie(film: Film, onSuccess:()->Unit)
    suspend fun deleteMovie(film: Film, onSuccess:()->Unit)
}