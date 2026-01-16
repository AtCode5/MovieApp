package com.example.movieapp.ui.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.DrawerValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.movieapp.ui.Remote.dto.DataClasses.CardViewDataClasses
import com.example.movieapp.ui.MainViewModel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailedScreen(
    viewModel: MainViewModel = viewModel(),
    movies: CardViewDataClasses,
    val1: Boolean,
    val2: Boolean
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = rememberTopAppBarState()
    )
    val scaffoldState = rememberScaffoldState()
    val state = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection)
            .background(Color.Black)
            .fillMaxSize(),
        topBar = {
            AppBar(
                string = movies.Title,
                scrollBehavior = scrollBehavior,
                scaffoldState,
                scope
            )
        },
        scaffoldState = scaffoldState
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .background(Color.Black)
                .fillMaxSize()
        ) {
            item {
                screen(viewModel = viewModel, movies, val1, val2)
            }
        }
    }
}

@Composable
fun screen(viewModel: MainViewModel, movies: CardViewDataClasses, val1: Boolean, val2: Boolean) {
    Column(
        modifier = Modifier
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .size(500.dp)
                .aspectRatio(1f),
            painter = rememberAsyncImagePainter(movies.Poster),
            contentDescription = "Poster",
        )
        Text(
            text = movies.Title + "(${movies.Year})",
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 3.dp)
        )
        Text(
            text = movies.Genre,
            color = Color.White,
            fontSize = 19.sp
        )
        Text(
            text = movies.Language,
            color = Color.White,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.padding(3.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.padding(3.dp))
        Text(
            text = "Decription",
            color = Color.White,
            fontSize = 22.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 8.dp, bottom = 2.dp)
        )
        Text(
            text = movies.Plot,
            color = Color.White,
            fontSize = 14.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.Start)
        )
        Spacer(modifier = Modifier.padding(3.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.padding(3.dp))
        Text(
            text = "Crew",
            color = Color.White,
            fontSize = 22.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 8.dp, bottom = 2.dp)
        )
        Row(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 8.dp)
        ) {
            Text(
                text = "Director:-",
                color = Color.White,
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
            )
            Text(
                text = movies.Director,
                color = Color.White,
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
            )
        }
        Row(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 8.dp)
        ) {
            Text(
                text = "Writer:- ",
                color = Color.White,
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
            )
            Text(
                text = movies.Writer,
                color = Color.White,
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
            )
        }
        Row(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 8.dp)
        ) {
            Text(
                text = "Actors:- ",
                color = Color.White,
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
            )
            Text(
                text = movies.Actors,
                color = Color.White,
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
            )
        }
        Row(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 8.dp)
        ) {
            Text(
                text = "Box Office:-",
                color = Color.White,
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
            )
            Text(
                text = movies.BoxOffice,
                color = Color.White,
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
            )
        }
        Spacer(modifier = Modifier.padding(3.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.padding(3.dp))
        var clicked1 by remember(val1) { mutableStateOf(val1) }
        var clicked2 by remember(val2) { mutableStateOf(val2) }
        Text(
            text = "Awards",
            color = Color.White,
            fontSize = 22.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 8.dp, bottom = 2.dp)
        )
        Text(
            text = movies.Awards,
            color = Color.White,
            fontSize = 14.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.Start)
        )
        Spacer(modifier = Modifier.padding(3.dp))
        HorizontalDivider()
        Spacer(modifier = Modifier.padding(3.dp))
        Row(
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(onClick = {
                    clicked1 = !clicked1
                }) {
                    Icon(
                        if (!clicked1) Icons.Outlined.FavoriteBorder else Icons.Filled.Favorite,
                        "favourites",
                        tint = if (!clicked1) Color.White else Color.Red
                    )
                }
                Text("Favourites", fontSize = 15.sp, color = Color.White)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(onClick = {
                    clicked2 = !clicked2
                    if (clicked2)
                        viewModel.addMovie(movies)
                    else
                        viewModel.deleteMovie(movies)
                }) {
                    Icon(
                        if (!clicked2) Icons.Outlined.Add else Icons.Default.Close,
                        "favourites",
                        tint = Color.White
                    )
                }
                Text(
                    if (!clicked2) "Add To Playlist" else "Remove",
                    fontSize = 15.sp,
                    color = Color.White
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(onClick = {
                }) {
                    Icon(Icons.Filled.Star, "favourites", tint = Color.Yellow)
                }
                Text(text = movies.imdbRating + "/10", fontSize = 15.sp, color = Color.White)
            }
        }
    }
}