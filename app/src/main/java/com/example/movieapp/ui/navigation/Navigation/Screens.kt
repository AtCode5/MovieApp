package com.example.movieapp.ui.navigation.Navigation

sealed class Screens(val route: String) {

    object FirstScreen: Screens("FirstScreen")
    object MoviesOfAllCategories:Screens("SecondScreen")
    object DetailedScreen:Screens("ThirdScreen")
    object PlaylistScreen:Screens("Playlist")
}