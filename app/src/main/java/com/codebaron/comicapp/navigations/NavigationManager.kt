package com.codebaron.comicapp.navigations

import androidx.compose.foundation.Image
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.codebaron.comicapp.screens.ui.ComicsHomeScreen
import com.codebaron.comicapp.screens.ui.FavouriteComicsScreen

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