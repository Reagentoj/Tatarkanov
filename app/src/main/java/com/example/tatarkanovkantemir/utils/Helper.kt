package com.example.tatarkanovkantemir.utils

import com.example.tatarkanovkantemir.data.room.MoviesRepositoryImpl
import com.example.tatarkanovkantemir.model.Country
import com.example.tatarkanovkantemir.model.Genre
import com.example.tatarkanovkantemir.presentation.MainActivity
import com.example.tatarkanovkantemir.presentation.fragments.movies.MoviesFragmentViewModel
import kotlin.properties.Delegates

// ну я же джун...
lateinit var mainActivityContext: MainActivity
var CURRENT_MOVIE_ID by Delegates.notNull<Int>()
lateinit var CURRENT_MOVIE_NAME: String
lateinit var CURRENT_MOVIE_GENRE: String
lateinit var CURRENT_MOVIE_COUNTRY: String
lateinit var CURRENT_MOVIE_POSTER: String
lateinit var MOVIES_FRAGMENT_VIEWMODEL: MoviesFragmentViewModel
lateinit var ROOM_REPOSITORY: MoviesRepositoryImpl
var MOVIE_ID by Delegates.notNull<Int>()

fun genresFormatter(genre: List<Genre>): String {
    var genres = "Жанры: "
    var length = genre.lastIndex
    for (i in genre){
        genres+=String.format(i.genre+if (length > genre.indexOf(i)) {", "} else { "" }
        )
    }
    return genres
}

fun countriesFormatter(country: List<Country>): String {
    var cpuntries = "Страны: "
    var length = country.lastIndex
    for (i in country){
        cpuntries+=String.format(i.country+if (length > country.indexOf(i)) {", "} else { "" }
        )
    }
    return cpuntries
}