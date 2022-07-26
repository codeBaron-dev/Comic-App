package com.codebaron.comicapp.mvvm

import com.codebaron.comicapp.models.ComicDTO

interface ComicRepository {
    suspend fun latestComicsAndSearchComics(comicId: String): ComicDTO?
}