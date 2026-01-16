package com.example.movieapp.ui.theme.RoomDataBase

import android.content.Context
import androidx.room.Room

object Graph {

    lateinit var dataBase: AppDataBase

    val appRepository by lazy{
        AppRepository(appDao = dataBase.movieDao())
    }

    fun provide(context: Context){
        dataBase= Room.databaseBuilder(context, AppDataBase::class.java,"movie.db").build()
    }
}