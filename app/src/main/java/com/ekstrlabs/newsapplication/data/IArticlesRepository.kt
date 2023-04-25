package com.ekstrlabs.newsapplication.data

import com.ekstrlabs.newsapplication.models.Article
import kotlinx.coroutines.flow.Flow

interface IArticlesRepository {

    val articles: Flow<List<Article>>

    suspend fun refreshAllArticles()

    suspend fun markAsRead(article: Article)

}