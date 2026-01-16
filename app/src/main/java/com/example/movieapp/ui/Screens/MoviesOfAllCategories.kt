package com.example.movieapp.ui.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.DrawerValue
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.movieapp.R
import com.example.movieapp.ui.Remote.dto.DataClasses.CardViewDataClasses
import com.example.movieapp.ui.MainViewModel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesOfAllCategories(
    string: String,
    viewModel: MainViewModel = viewModel(),
    navigateToDetailedScreen: (CardViewDataClasses) -> Unit,
    navigateToPlaylist:(String)-> Unit
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = rememberTopAppBarState()
    )
    val movieState = viewModel.moviesState.value
    val scaffoldState= rememberScaffoldState()
    val state = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            AppBar(
                string = string,
                scrollBehavior = scrollBehavior,
                scaffoldState,
                scope
            )
        },
        scaffoldState = scaffoldState,
        drawerContent = {
            Column(modifier = Modifier.fillMaxSize()
                .statusBarsPadding()
                .padding(15.dp)
                .background(Color.Black)) {
                Image(painter = painterResource(R.drawable.profile),
                    contentDescription = "Profile",
                    modifier = Modifier.clip(CircleShape))
                Spacer(modifier = Modifier.padding(top =13.dp ))
                Column(modifier = Modifier.fillMaxSize().background(Color.Black).padding(5.dp)) {
                    Text(text = string,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(R.color.white),
                        fontSize = 30.sp)

                    Spacer(modifier = Modifier.padding(top =13.dp ))
                    Divider(color = Color.LightGray)
                    Spacer(modifier = Modifier.padding(top =5.dp ))
                    Row(modifier = Modifier.clickable(onClick = {
                        navigateToPlaylist("Playlist")
                    })) {
                        Icon(Icons.Default.PlayArrow,"", tint = Color.White)
                        Text(text = "Playlist",
                            fontWeight = FontWeight.Bold,
                            color = colorResource(R.color.white),
                            fontSize = 20.sp)
                    }
                }
            }
        },
        drawerBackgroundColor = colorResource(R.color.black)
    ) { paddingValues ->
        LazyVerticalGrid(
            contentPadding = paddingValues,
            columns = GridCells.Fixed(count = 2),
            modifier = Modifier
                .background(Color.Black)
                .fillMaxSize()
        ) {
            items(movieState.list) { movies ->
                CardViewLanguage(movies, navigateToDetailedScreen)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    string: String,
    scrollBehavior: TopAppBarScrollBehavior,
    scaffoldState: ScaffoldState,
    scope: CoroutineScope
) {
    Column {
        TopAppBar(
            title = {
                Text(
                    "$string",
                    color = colorResource(R.color.white),
                    fontWeight = FontWeight.Bold
                )
            },
            navigationIcon = {
                IconButton(
                    onClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    },
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = colorResource(R.color.white),
                        disabledContentColor = colorResource(R.color.white)
                    )
                ) {
                    Icon(Icons.Default.Menu, "Menu", tint = Color.White)
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                scrolledContainerColor = colorResource(R.color.black),
                containerColor = colorResource(R.color.black),
                navigationIconContentColor = colorResource(R.color.white)
            ),
            scrollBehavior = scrollBehavior,
            modifier = Modifier.statusBarsPadding()
        )
        Divider()
    }
}

@Composable
fun CardViewLanguage(
    movies: CardViewDataClasses,
    navigateToDetailedScreen: (CardViewDataClasses) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp, bottom = 10.dp, start = 8.dp, end = 8.dp)
            .wrapContentWidth()
            .clickable(onClick = {
                navigateToDetailedScreen(movies)
            }),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.padding(top = 10.dp))
        Image(
            painter = rememberAsyncImagePainter(movies.Poster), contentDescription = "movie",
            modifier = Modifier
                .aspectRatio(0.7f)
                .fillMaxWidth()
                .size(50.dp)
                .shadow(13.dp)
        )
        Spacer(modifier = Modifier.padding(top = 10.dp))
        Text(
            text = movies.Title + " (${movies.Year})",
            fontSize = 20.sp,
            color = colorResource(R.color.white),
            textAlign = TextAlign.Center
        )

    }
}
//@Preview(showSystemUi = true)
//@Composable
//fun Show2() {
//    MoviesOfAllCategories("Atul")
//}