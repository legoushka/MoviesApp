package com.example.moviesapp.data.network

import com.example.moviesapp.data.models.Movies
import com.example.moviesapp.domain.repository.MoviesRepository
import retrofit2.Response
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) : MoviesRepository {

    override suspend fun getAllMovies(): Response<List<Movies>> = apiService.getAllMovies()
}