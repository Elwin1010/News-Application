package com.ekstrlabs.newsapplication

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ekstrlabs.newsapplication.data.database.ArticlesDao
import com.ekstrlabs.newsapplication.data.database.ArticlesDatabase
import com.ekstrlabs.newsapplication.utils.ArticleDatabaseTestUtils
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException


@RunWith(AndroidJUnit4::class)
class ArticleDatabaseTests {

    private lateinit var dao: ArticlesDao
    private lateinit var db: ArticlesDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, ArticlesDatabase::class.java).build()
        dao = db.dao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun markArticleAsRead() = runBlocking {

        val articles = ArticleDatabaseTestUtils.generateTestDatabaseArticles()

        val testArticle = articles[0]

        dao.upsertArticles(articles)

        // Before reading, unread
        val articleBefore = dao.getArticleById(testArticle.id).first()
        assert(
            articleBefore.isRead == false
        )

        // Mark as read
        dao.markArticleAsReadById(testArticle.id)

        // Check if is read
        val articleAfter = dao.getArticleById(testArticle.id).first()
        assert(
            articleAfter.isRead == true
        )

    }

}