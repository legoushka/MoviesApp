package com.example.moviesapp.domain.repository

import com.example.moviesapp.data.models.Movies
import retrofit2.Response

interface MoviesRepository {

    suspend fun getAllMovies() : Response<List<Movies>>
}