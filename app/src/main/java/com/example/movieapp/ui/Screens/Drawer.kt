package com.example.movieapp.ui.Screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun navigationDrawer(
) {


    ModalNavigationDrawer(
        drawerContent = {

            ModalDrawerSheet() {
                Column(modifier = Modifier.fillMaxSize()) {
                    Image(
                        painterResource(R.drawable.profile),
                        "Profile",
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(130.dp)
                            .aspectRatio(1f)
                    )
                    Text(
                        text = "UserName",
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                    NavigationDrawerItem(
                        label = {
                            Text("Playlist")
                        },
                        onClick = {},
                        selected = false
                    )
                }
            }
        }
    ) {}
}