package com.example.tatarkanovkantemir.data

import com.example.tatarkanovkantemir.data.retrofit.RetrofitInstance
import com.example.tatarkanovkantemir.model.MovieDetails
import com.example.tatarkanovkantemir.model.MoviesModel
import com.example.tatarkanovkantemir.utils.Const
import retrofit2.Call
import retrofit2.Response

class RetrofitRepository {
    suspend fun getMovies(): Response<MoviesModel> {
        return RetrofitInstance.api.getMovies(
            Const.API_KEY_VALUE,
            Const.TOP_FILM,
            Const.PAGE)
    }

    suspend fun getMovieDetail(movieId: Int) : Response<MovieDetails> {
        return RetrofitInstance.api.getMovieDetails(Const.API_KEY_VALUE, movieId)
    }
}