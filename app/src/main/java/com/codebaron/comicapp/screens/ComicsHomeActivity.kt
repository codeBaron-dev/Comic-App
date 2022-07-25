@file:OptIn(ExperimentalMaterial3Api::class)

package com.codebaron.comicapp.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.codebaron.comicapp.R
import com.codebaron.comicapp.navigations.Destinations
import com.codebaron.comicapp.navigations.NAVIGATION_OBJECTS
import com.codebaron.comicapp.screens.ui.ComicsHomeScreen
import com.codebaron.comicapp.screens.ui.FavouriteComicsScreen
import com.codebaron.comicapp.ui.theme.ComicAppTheme
import com.codebaron.comics.Utils.CustomMaterialDialog
import com.codebaron.comics.Utils.isNetworkAvailable

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
fun BottomNav(navController: NavController) {
    NavigationBar {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        NAVIGATION_OBJECTS.forEach { route ->
            NavigationBarItem(
                icon = {
                    Image(
                        imageVector = route.icon,
                        contentDescription = route.title
                    )
                },
                label = {
                    Text(
                        text = route.title
                    )
                },
                alwaysShowLabel = true,
                selected = currentRoute == route.destinations,
                onClick = {
                    navController.navigate(route.destinations) {
                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun ScreenNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Destinations.COMICS_HOME_SCREEN.name) {
        composable(Destinations.COMICS_HOME_SCREEN.name) {
            ComicsHomeScreen(navController)
        }
        composable(Destinations.COMICS_FAVOURITE_SCREEN.name) {
            FavouriteComicsScreen()
        }
    }
}