package com.example.tatarkanovkantemir.data.retrofit

import com.example.tatarkanovkantemir.model.MovieDetails
import com.example.tatarkanovkantemir.model.MoviesModel
import com.example.tatarkanovkantemir.utils.Const
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("api/v2.2/films/top")
    suspend fun getMovies(
        @Header(Const.API_KEY) apiKey: String,
        @Query("type") topFilms: String,
        @Query("page") page: Int
    ): Response<MoviesModel>

    @GET("api/v2.2/films/{movie_id}")
    suspend fun getMovieDetails(
        @Header(Const.API_KEY) apiKey: String,
        @Path("movie_id") movieId: Int
    ): Response<MovieDetails>
}