package com.codebaron.comicapp.mvvm

import com.codebaron.comicapp.models.ComicDTO
import com.codebaron.comicapp.repository.ApiEndPoints
import javax.inject.Inject

class ComicRepositoryImplementation @Inject constructor(private val apiEndPoints: ApiEndPoints) :
    ComicRepository {

    override suspend fun latestComicsAndSearchComics(comicId: String): ComicDTO? {
        val response = apiEndPoints.latestComicsAndSearchComics(comicId)
        return if (response.isSuccessful) {
            response.body()
        } else {
            throw Exception()
        }
    }
}