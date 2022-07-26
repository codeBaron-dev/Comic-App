package com.codebaron.comicapp.repository

import com.codebaron.comicapp.models.ComicDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndPoints {

    @GET(SEARCH_COMIC)
    suspend fun latestComicsAndSearchComics(@Path("comicId") comicId: String): Response<ComicDTO>
}