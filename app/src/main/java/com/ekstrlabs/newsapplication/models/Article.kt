package com.ekstrlabs.newsapplication.models

data class Article(

    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String,
    val categories: List<String>,

    val isRead: Boolean

)
