package com.codebaron.comicapp.screens

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codebaron.comicapp.R
import com.codebaron.comicapp.ui.theme.ComicAppTheme
import com.codebaron.comics.Utils.CustomMaterialDialog
import com.codebaron.comics.Utils.isNetworkAvailable
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComicAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SplashScreen()
                    if (isNetworkAvailable(this)) {
                        LaunchedEffect(Unit) {
                            delay(2000)
                            startActivity(Intent(this@MainActivity, ComicsHomeActivity::class.java))
                        }
                    } else {
                        CustomMaterialDialog(
                            "No Internet Connection",
                            "To have a google experience with this ${R.string.app_name}, please ensure you're have a stable internet connection",
                            "Okay", "Cancel"
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SplashScreen() {
    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column {
                Image(
                    modifier = Modifier
                        .height(200.dp)
                        .width(300.dp),
                    painter = painterResource(id = R.drawable.ic_undraw_handcrafts_planet),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth
                )
                Spacer(modifier = Modifier.size(30.dp))
                Text(
                    text = "Planet Comics..",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComicAppTheme {
        SplashScreen()
    }
}