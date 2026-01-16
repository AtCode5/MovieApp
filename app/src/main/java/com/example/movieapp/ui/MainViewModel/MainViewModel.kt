package com.example.movieapp.ui.MainViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.ui.Remote.Api.ApiService.cardService
import com.example.movieapp.ui.Remote.dto.DataClasses.CardViewDataClasses
import com.example.movieapp.ui.theme.RoomDataBase.AppRepository
import com.example.movieapp.ui.theme.RoomDataBase.Graph
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainViewModel(private val appRepository: AppRepository = Graph.appRepository) : ViewModel() {

    private val _moviesState = mutableStateOf(MoviesState())

    val moviesState: State<MoviesState> = _moviesState


    init {
        moviesList()
    }

    private fun moviesList() {
        viewModelScope.launch {
            try {
                val response = cardService.getMovies()
                _moviesState.value = _moviesState.value.copy(
                    loading = false,
                    list = response.movies,
                    error = null
                )
            } catch (e: Exception) {
                _moviesState.value = _moviesState.value.copy(
                    loading = false,
                    error = "Error Ocurred While fetching Movies"+e
                )
            }
        }
    }

    var getAllMovies: Flow<List<CardViewDataClasses>> = appRepository.getAllMovies()


    fun addMovie(movie: CardViewDataClasses){
        viewModelScope.launch {
            appRepository.addMovie(movie)
        }
    }
    fun deleteMovie(movie: CardViewDataClasses){
        viewModelScope.launch {
            appRepository.deleteMovie(movie)
        }
    }
    fun updateMovie(movie: CardViewDataClasses){
        viewModelScope.launch {
            appRepository.updateMovie(movie)
        }
    }
    fun getMoviesById(id: String): Flow<CardViewDataClasses?> {
        return appRepository.getMoviesById(id)
    }
}


data class MoviesState(
    val loading: Boolean = false,
    val list: List<CardViewDataClasses> = emptyList(),
    val error: String? = null
)