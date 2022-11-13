package com.example.moviesapp.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.data.models.Movies
import com.example.moviesapp.domain.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository
) : ViewModel() {

    private val _allMovies = MutableLiveData<List<Movies>>()
    val allMovies: LiveData<List<Movies>>
        get() = _allMovies


    fun getAllMovies() {
        viewModelScope.launch {
            moviesRepository.getAllMovies().let { response ->
                if (response.isSuccessful){
                    _allMovies.postValue(response.body())
                }
                else {
                    Log.d("checkData", "Failed to load movies: ${response.errorBody()}")
                }
            }
        }
    }
}