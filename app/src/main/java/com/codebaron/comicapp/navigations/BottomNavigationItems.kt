package com.codebaron.comicapp.navigations

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationItems(
    var title: String,
    var icon: ImageVector,
    var destinations: String
) {

    object Shelf : BottomNavigationItems(
        "Comics",
        Icons.Default.Book,
        Destinations.COMICS_HOME_SCREEN.name
    )

    object Favourites : BottomNavigationItems(
        "Favourites",
        Icons.Default.Favorite,
        Destinations.COMICS_FAVOURITE_SCREEN.name
    )
}
val NAVIGATION_OBJECTS = listOf(BottomNavigationItems.Shelf, BottomNavigationItems.Favourites)