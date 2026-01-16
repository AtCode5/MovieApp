package com.example.movieapp.ui.theme.RoomDataBase

import android.app.Application

class MovieAppForDB: Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}