package com.example.tatarkanovkantemir.utils

import android.os.Bundle
import com.example.tatarkanovkantemir.R
import com.example.tatarkanovkantemir.model.Film
import com.example.tatarkanovkantemir.utils.MOVIE_ID
import com.example.tatarkanovkantemir.utils.countriesFormatter
import com.example.tatarkanovkantemir.utils.genresFormatter
import com.example.tatarkanovkantemir.utils.mainActivityContext


object OnMovieClick {

    fun onClickFromMoviesFragment(film: Film) {
        val bundle = Bundle()
        bundle.putString("title", film.nameRu)
        bundle.putString("year", film.year)
        bundle.putString("genre", genresFormatter(film.genres))
        bundle.putString("country", countriesFormatter(film.countries))
        bundle.putString("poster", film.posterUrl)
        bundle.putInt("id", film.filmId)
        MOVIE_ID = film.filmId
        mainActivityContext.navController
            .navigate(R.id.action_moviesFragment_to_movieDetailsFragment, bundle)

    }

    fun onClickFromFavoriteFragment(film: Film) {
        val bundle = Bundle()
        bundle.putString("title", film.nameRu)
        bundle.putString("year", film.year)
        bundle.putString("genre", genresFormatter(film.genres))
        bundle.putString("country", countriesFormatter(film.countries))
        bundle.putString("poster", film.posterUrl)
        bundle.putInt("id", film.filmId)
        MOVIE_ID = film.filmId
        mainActivityContext.navController
            .navigate(R.id.action_favoriteMoviesFragment_to_movieDetailsFragment, bundle)

    }

}