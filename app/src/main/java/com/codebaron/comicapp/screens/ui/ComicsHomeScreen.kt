@file:OptIn(ExperimentalMaterial3Api::class)

package com.codebaron.comicapp.screens.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.codebaron.comicapp.models.ComicDTO
import com.codebaron.comicapp.models.dummyComicDTOList

@Composable
fun ComicsHomeScreen(navController: NavHostController) {
    LazyColumn {
        item {
            SearchBar(modifier = Modifier.fillMaxWidth())
        }
        items(dummyComicDTOList) { comics ->
            ComicScreenUI(comics)
        }
    }
}

@Composable
fun ComicScreenUI(comics: ComicDTO) {
    Card(
        modifier =
        Modifier
            .padding(16.dp)
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
                    .height(250.dp),
                painter = rememberAsyncImagePainter(model = comics.img), contentDescription = null,
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
                                imageVector = Icons.Outlined.Favorite,
                                contentDescription = "Favourite",
                                modifier = Modifier.clickable { }
                            )
                        }
                    }
                }
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