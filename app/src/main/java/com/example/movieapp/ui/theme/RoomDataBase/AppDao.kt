package com.example.movieapp.ui.theme.RoomDataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.movieapp.ui.Remote.dto.DataClasses.CardViewDataClasses
import kotlinx.coroutines.flow.Flow

@Dao
abstract class AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun add(movieEntity: CardViewDataClasses)

    @Query("Select * from`Movie_Table`")
    abstract fun fetchAllMovies(): Flow<List<CardViewDataClasses>>

    @Update
    abstract suspend fun updateMovie(movieEntity: CardViewDataClasses)

    @Delete
    abstract suspend fun deleteMovie(movieEntity: CardViewDataClasses)

    @Query("Select * from `Movie_Table` where imdbID=:imdbId")
    abstract fun fetchByTitle(imdbId: String): Flow<CardViewDataClasses?>
}