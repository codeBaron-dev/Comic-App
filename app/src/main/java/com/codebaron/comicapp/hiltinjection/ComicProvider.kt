package com.codebaron.comicapp.hiltinjection

import com.codebaron.comicapp.mvvm.ComicRepository
import com.codebaron.comicapp.mvvm.ComicRepositoryImplementation
import com.codebaron.comicapp.repository.ApiEndPoints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module @InstallIn(SingletonComponent::class)
class ComicProvider {
    @Provides @Singleton
    fun provideComics(apiEndPoints: ApiEndPoints): ComicRepository = ComicRepositoryImplementation(apiEndPoints)
}