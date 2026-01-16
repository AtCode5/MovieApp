package com.example.movieapp.ui.Remote.Api.ApiService

import com.example.movieapp.ui.Remote.dto.DataClasses.Response
import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import kotlin.jvm.java

private val retrofit = Retrofit.Builder().baseUrl("https://raw.githubusercontent.com/toedter/movies-demo/refs/heads/master/backend/src/main/resources/static/movie-data/")
    .addConverterFactory(GsonConverterFactory.create()).build()

val cardService=retrofit.create(CardService::class.java)

interface CardService{
    @GET(value="movies-250.json")
    suspend fun getMovies(): Response
}



