package com.ekstrlabs.newsapplication.data.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.ekstrlabs.newsapplication.data.database.entities.DatabaseArticle
import com.ekstrlabs.newsapplication.data.network.entities.NetworkArticle
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticlesDao {

    @Query("SELECT * from articles")
    fun getAllArticles(): Flow<List<DatabaseArticle>>

    @Upsert
    suspend fun upsertArticles(articles: List<DatabaseArticle>)

    /*
     * This will INSERT when the primary key combination does not yet exist,
     * otherwise it will UPDATE the corresponding row.
     *
     * Since "isRead" is not omitted through the API, and is only saved locally in the DB,
     * we use partial data to update the DB: the isRead value of the row will persist, since it
     * does not exist in the NetworkApplication data class
     */
    @Upsert(
        entity = DatabaseArticle::class
    )
    suspend fun upsertArticlesFromNetwork(articles: List<NetworkArticle>)


    @Query("UPDATE articles SET isRead = 1 WHERE id = :articleId")
    suspend fun markArticleAsReadById(articleId: Int)

}