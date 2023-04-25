package com.ekstrlabs.newsapplication.data

import com.ekstrlabs.newsapplication.models.Article
import kotlinx.coroutines.flow.Flow

interface IArticlesRepository {

    val articles: Flow<List<Article>>

    suspend fun refreshAllArticles()

    fun markAsRead(article: Article)

}