package com.ekstrlabs.newsapplication.data.database

import androidx.room.Database
import androidx.room.TypeConverters
import androidx.room.RoomDatabase
import com.ekstrlabs.newsapplication.data.database.entities.DatabaseArticle


@Database(
    entities = [
        DatabaseArticle::class
    ],
    version = 2
)
@TypeConverters(
    ListTypeConverters::class
)
abstract class ArticlesDatabase: RoomDatabase() {

    abstract val dao: ArticlesDao

}