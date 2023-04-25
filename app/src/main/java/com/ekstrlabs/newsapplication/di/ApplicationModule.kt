package com.ekstrlabs.newsapplication.di

import android.app.Application
import androidx.room.Room
import com.ekstrlabs.newsapplication.data.ArticlesRepository
import com.ekstrlabs.newsapplication.data.database.ArticlesDatabase
import com.ekstrlabs.newsapplication.data.network.ArticlesApi
import com.ekstrlabs.newsapplication.data.network.ArticlesApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideArticlesDatabase(app: Application): ArticlesDatabase {
        return Room.databaseBuilder(
            context = app,
            name = "articles_db",
            klass = ArticlesDatabase::class.java
        ).build()
    }

    @Provides
    @Singleton
    fun provideArticlesApi(): ArticlesApiService {
        return ArticlesApi.retrofit
    }


    @Provides
    @Singleton
    fun provideArticlesRepository(database: ArticlesDatabase, api: ArticlesApiService): ArticlesRepository {
        return ArticlesRepository(
            database = database,
            api = api
        );
    }

}