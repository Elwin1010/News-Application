package com.ekstrlabs.newsapplication.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ekstrlabs.newsapplication.models.Article

@Entity(
    tableName = "articles"
)
data class DatabaseArticle(

    @PrimaryKey(true) val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String,
    val categories: List<String>,

    @ColumnInfo(
        defaultValue = "false"
    )
    val isRead: Boolean? = false

)


/*
    Extension to transform DatabaseArticle into Domain Article Model
 */
fun DatabaseArticle.asDomainModel(): Article {
    return Article(
        id = this.id,
        title = this.title,
        description = this.description,
        imageUrl = this.imageUrl,
        categories = this.categories,
        isRead = this.isRead == true
    )
}
