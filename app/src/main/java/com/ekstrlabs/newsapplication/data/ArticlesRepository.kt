package com.ekstrlabs.newsapplication.data

import com.ekstrlabs.newsapplication.data.database.ArticlesDatabase
import com.ekstrlabs.newsapplication.data.database.entities.asDomainModel
import com.ekstrlabs.newsapplication.data.network.ArticlesApiService
import com.ekstrlabs.newsapplication.models.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject


class ArticlesRepository @Inject constructor(
    private val database: ArticlesDatabase,
    private val api: ArticlesApiService
): IArticlesRepository {

    override val articles: Flow<List<Article>> = database.dao.getAllArticles().map { list ->
        list.map { it.asDomainModel() }
    }

    override suspend fun refreshAllArticles() {
        withContext(Dispatchers.IO) {

            val wrapper = api.getArticles();
            database.dao.upsertArticlesFromNetwork(wrapper.articles);

        }
    }

    override suspend fun markAsRead(article: Article) {
        database.dao.markArticleAsReadById(article.id)
    }


}