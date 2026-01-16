package com.example.movieapp.ui.navigation.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.ui.Remote.dto.DataClasses.CardViewDataClasses
import com.example.movieapp.ui.Screens.DetailedScreen
import com.example.movieapp.ui.Screens.FirstScreen
import com.example.movieapp.ui.Screens.MoviesOfAllCategories
import com.example.movieapp.ui.Screens.ShowPlaylist

@Composable
fun MyApp() {
    val navHostController = rememberNavController()
    NavHost(navHostController, startDestination = Screens.FirstScreen.route) {
        composable(Screens.FirstScreen.route) {
            FirstScreen { it ->
                navHostController.currentBackStackEntry?.savedStateHandle?.set("name", it)
                navHostController.navigate(Screens.MoviesOfAllCategories.route)
            }
        }
        composable(Screens.MoviesOfAllCategories.route) {
            val username =
                navHostController.previousBackStackEntry?.savedStateHandle?.get<String>("name")
                    ?: ("")
            MoviesOfAllCategories(
                string = username,
                navigateToDetailedScreen = {movie ->
                    navHostController.currentBackStackEntry?.savedStateHandle?.set("movie", movie)
                    navHostController.currentBackStackEntry?.savedStateHandle?.set("isFavorite", false)
                    navHostController.currentBackStackEntry?.savedStateHandle?.set(
                        "isInPlaylist",
                        false
                    )
                    navHostController.navigate(Screens.DetailedScreen.route)

                },
                navigateToPlaylist = {it->
                    navHostController.currentBackStackEntry?.savedStateHandle?.set("name",it)
                    navHostController.navigate(Screens.PlaylistScreen.route)
                }
            )
        }
        composable(route = Screens.DetailedScreen.route) {
            val sourceEntry = navHostController.previousBackStackEntry
            val movie = sourceEntry?.savedStateHandle
                ?.get<CardViewDataClasses>("movie")
                ?: CardViewDataClasses(
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    emptyArray(),
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    ""
                )
            val isFavorite = sourceEntry?.savedStateHandle?.get<Boolean>("isFavorite") ?: false
            val isInPlaylist = sourceEntry?.savedStateHandle?.get<Boolean>("isInPlaylist") ?: false
            DetailedScreen(movies = movie, val1 = isInPlaylist, val2 = isFavorite)
        }
        composable(Screens.PlaylistScreen.route) {
            val name=navHostController.previousBackStackEntry?.savedStateHandle
                ?.get<String>("name")?:""
            ShowPlaylist(name,navHostController=navHostController)
        }
    }
}