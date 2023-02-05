package com.example.tatarkanovkantemir.data.room

import androidx.lifecycle.LiveData
import com.example.tatarkanovkantemir.model.Film

class MoviesRepositoryImpl(private val dao: Dao) : MoviesRepository {

    override val movies: LiveData<List<Film>>
        get() = dao.getMovies()



    override suspend fun insertMovie(film: Film, onSuccess: () -> Unit) {
        dao.insert(film)
        onSuccess()
    }

    override suspend fun deleteMovie(film: Film, onSuccess: () -> Unit) {
        dao.delete(film)
        onSuccess()
    }

}