@file:OptIn(ExperimentalMaterial3Api::class)

package com.codebaron.comicapp.screens.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.codebaron.comicapp.R
import com.codebaron.comicapp.models.ComicDTO
import com.codebaron.comicapp.mvvm.ComicViewModel
import com.codebaron.comicapp.navigations.BottomNav
import com.codebaron.comicapp.navigations.ScreenNavigation
import com.codebaron.comicapp.ui.theme.ComicAppTheme
import com.codebaron.comics.Utils.CustomMaterialDialog
import com.codebaron.comics.Utils.isNetworkAvailable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComicsHomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComicAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    if (!isNetworkAvailable(this)) {
                        CustomMaterialDialog(
                            "No Internet Connection",
                            "To have a google experience with this ${R.string.app_name}, please ensure you're have a stable internet connection",
                            "Okay", "Cancel"
                        )
                    }
                    BottomNavBar(navController)
                }
            }
        }
    }
}

@Composable
fun BottomNavBar(navController: NavHostController) {
    Scaffold(
        bottomBar = { BottomNav(navController) }
    ) {
        ScreenNavigation(navController = navController)
    }
}

@Composable
fun ComicsRequestHandler(comicId: String, comicViewModel: ComicViewModel = hiltViewModel()): ComicDTO? {
    return comicViewModel.latestComicsAndSearchComics(comicId).observeAsState().value
}