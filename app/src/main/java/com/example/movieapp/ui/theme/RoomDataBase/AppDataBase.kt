package com.example.movieapp.ui.theme.RoomDataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.movieapp.ui.Remote.dto.DataClasses.CardViewDataClasses
import com.example.movieapp.ui.Remote.dto.DataClasses.Converters


@Database(
    entities = [CardViewDataClasses::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(Converters::class)
abstract class AppDataBase: RoomDatabase() {
    abstract fun movieDao(): AppDao
}