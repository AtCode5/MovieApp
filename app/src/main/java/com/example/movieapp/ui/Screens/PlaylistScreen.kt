package com.example.movieapp.ui.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.movieapp.R
import com.example.movieapp.ui.Remote.dto.DataClasses.CardViewDataClasses
import com.example.movieapp.ui.MainViewModel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowPlaylist(
    string: String,
    viewModel: MainViewModel = viewModel(),
    navHostController: NavHostController
) {

    val movies by viewModel.getAllMovies.collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    androidx.compose.material3.Text(
                        "$string",
                        color = colorResource(R.color.white),
                        fontWeight = FontWeight.Bold
                    )

                },
                navigationIcon = {
                    androidx.compose.material3.IconButton(
                        onClick = {
                            navHostController.navigateUp()
                        },
                        colors = IconButtonDefaults.iconButtonColors(
                            contentColor = colorResource(R.color.white),
                            disabledContentColor = colorResource(R.color.white)
                        )
                    ) {
                        Icon(Icons.Default.ArrowBack, "Back", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    scrolledContainerColor = colorResource(R.color.black),
                    containerColor = colorResource(R.color.black),
                    navigationIconContentColor = colorResource(R.color.white)
                ),
                modifier = Modifier.statusBarsPadding()
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(movies) { movie ->
                MovieView(movie)
            }
        }
    }
}

@Composable
fun MovieView(movie: CardViewDataClasses, viewModel: MainViewModel = viewModel()) {
    Spacer(modifier = Modifier.padding(top = 5.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth().padding(end=7.dp),
        verticalAlignment = Alignment.Top
    ) {
        Image(
            painter = rememberAsyncImagePainter(movie.Poster), "Poster",
            modifier = Modifier
                .size(130.dp)
                .aspectRatio(1f)
        )
        Column(modifier = Modifier.fillMaxWidth(0.9f).padding(end = 8.dp)) {
            Text(
                text = movie.Title,
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.padding(bottom = 3.dp))
            Text(
                text = movie.Genre,
                fontSize = 15.sp,
                color = Color.White,
                fontWeight = FontWeight.Normal,
            )
            Spacer(modifier = Modifier.padding(bottom = 3.dp))
            Text(
                text = movie.Language,
                fontSize = 13.sp,
                color = Color.White,
                fontWeight = FontWeight.Normal,
            )
            Spacer(modifier = Modifier.padding(bottom = 3.dp))
        }
        Column() {
            IconButton(onClick = {
                viewModel.deleteMovie(movie)
            }) {
                Icon(Icons.Default.Close,"Close",
                    tint = Color.White, modifier = Modifier.offset(y=(-12).dp))
            }
        }
    }
    Spacer(modifier = Modifier.padding(top=5.dp,bottom =5.dp))
}
