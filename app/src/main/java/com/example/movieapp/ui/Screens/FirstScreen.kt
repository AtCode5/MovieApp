package com.example.movieapp.ui.Screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieapp.R


@Composable
fun FirstScreen(navigateToMoviesOfAllCategories:(String)-> Unit) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.black)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var text = remember {
            mutableStateOf("")
        }

        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "AppLogo",
            modifier = Modifier.clip(CircleShape)
        )

        Text(
            "MovieZ",
            color = Color.White,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(top = 3.dp))
        Text(
            "Cinema Dil Se",
            color = Color.White,
            fontSize = 17.sp
        )

        Spacer(modifier = Modifier.padding(top = 35.dp))

        Text(
            text="Your personalized movie hub for effortless discovery and tracking. Find the next film to watch, save your favorites, and manage your watchlist all in one place.",
            color = Color.White,
            fontSize = 15.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 13.dp)
        )

        Spacer(modifier = Modifier.padding(top = 10.dp))
        OutlinedTextField(
            value = text.value,
            onValueChange = { it ->
                text.value = it
            },
            label = {
                Text("Username", fontSize = 18.sp)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(13.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(R.color.red),
                focusedLabelColor = Color.White,
                unfocusedBorderColor = colorResource(R.color.red),
                unfocusedLabelColor = Color.White,
                focusedTextColor = Color.White
            )
        )

        Button(
            onClick = {
                navigateToMoviesOfAllCategories(text.value)
            },
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 13.dp, end = 13.dp),
            colors = ButtonDefaults.buttonColors(colorResource(R.color.red))
        ) {
            Text("Next")
        }

    }
}

//@Preview(showSystemUi = true)
//@Composable
//fun show() {
//    FirstScreen()
//}