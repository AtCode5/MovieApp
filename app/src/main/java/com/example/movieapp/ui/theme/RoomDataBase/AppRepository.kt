package com.example.movieapp.ui.theme.RoomDataBase
import com.example.movieapp.ui.Remote.dto.DataClasses.CardViewDataClasses
import kotlinx.coroutines.flow.Flow

class AppRepository(private val appDao: AppDao){

    suspend fun addMovie(movie: CardViewDataClasses){
        appDao.add(movie)
    }
    suspend fun deleteMovie(movie: CardViewDataClasses){
        appDao.deleteMovie(movie)
    }
    fun getAllMovies():Flow<List<CardViewDataClasses>>{
        return appDao.fetchAllMovies()
    }

    suspend fun updateMovie(movie: CardViewDataClasses){
        appDao.updateMovie(movie)
    }
    fun getMoviesById(id: String): Flow<CardViewDataClasses?>{
        return appDao.fetchByTitle(id)
    }
}