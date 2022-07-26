@file:OptIn(ExperimentalMaterial3Api::class)

package com.codebaron.comicapp.screens.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.codebaron.comicapp.roomdb.ComicRoomDatabase

@Composable
fun FavouriteComicsScreen() {
    val context = LocalContext.current
    val localDatabase = ComicRoomDatabase(context).ComicDao().getAllLocalComics()

    LazyColumn {
        items(localDatabase) { comics ->
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
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}