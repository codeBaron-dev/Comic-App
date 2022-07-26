@file:OptIn(ExperimentalMaterial3Api::class)

package com.codebaron.comicapp.screens.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.codebaron.comicapp.models.ComicDTO
import com.codebaron.comicapp.roomdb.ComicRoomDatabase
import com.codebaron.comicapp.screens.activities.ComicsRequestHandler

@Composable
fun ComicsHomeScreen(navController: NavHostController) {
    val comicId = remember { mutableStateOf(1) }

    Column {
        SearchBar(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.size(40.dp))
        val latestComics = ComicsRequestHandler(comicId.value.toString())
        latestComics?.let { ComicScreenUI(comics = it, navController = navController) { } }
    }
}

@Composable
fun ComicScreenUI(comics: ComicDTO, navController: NavHostController, onClick: () -> Unit) {
    val context = LocalContext.current
    val isFavourite = remember { mutableStateOf(false) }

    Column(
        modifier =
        Modifier
            .padding(16.dp)
    ) {
        Card(
            modifier =
            Modifier
                .clickable { }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(450.dp),
                    painter = rememberAsyncImagePainter(model = comics.img),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
                Spacer(modifier = Modifier.size(10.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                ) {
                    Column {
                        Text(
                            text = comics.title,
                            style = MaterialTheme.typography.displayLarge,
                            maxLines = 1,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.size(5.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Release date: ${comics.day}-${comics.month}-${comics.year}",
                                style = MaterialTheme.typography.displaySmall,
                                maxLines = 1,
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .width(100.dp),
                                contentAlignment = Alignment.CenterEnd,
                            ) {
                                Icon(
                                    imageVector = if (isFavourite.value) Icons.Outlined.Favorite else Icons.Filled.Favorite,
                                    contentDescription = "Favourite",
                                    modifier = Modifier.clickable {
                                        isFavourite.value = true
                                        val localDatabase = ComicRoomDatabase(context)
                                        localDatabase.ComicDao().insertComic(comics)
                                        Toast.makeText(
                                            context,
                                            "Added to favourite",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    },
                                    tint = if (!isFavourite.value) Color.Black else  Color.Red
                                )
                            }
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.size(40.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.SkipPrevious, contentDescription = "Previous")
                Text(text = "Previous")
            }
            Button(onClick = {
                onClick.invoke()
            }) {
                Text(text = "Next")
                Icon(imageVector = Icons.Default.SkipNext, contentDescription = "Previous")
            }
        }
    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.surface, CircleShape)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                modifier = Modifier.padding(start = 16.dp),
                tint = MaterialTheme.colorScheme.outline
            )
            Text(
                text = "Search Comics",
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.outline
            )
        }
    }
}