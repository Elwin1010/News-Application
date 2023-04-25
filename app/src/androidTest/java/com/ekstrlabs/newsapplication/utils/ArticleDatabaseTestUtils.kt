package com.ekstrlabs.newsapplication.utils

import com.ekstrlabs.newsapplication.data.database.entities.DatabaseArticle

object ArticleDatabaseTestUtils {

    fun generateTestDatabaseArticles(): List<DatabaseArticle> {
        return listOf(
            DatabaseArticle(
                id = 1,
                title = "Title",
                description = "Description",
                imageUrl = "",
                categories = listOf(
                    "Buitenland", "Economie"
                ),
            )
        )
    }


}