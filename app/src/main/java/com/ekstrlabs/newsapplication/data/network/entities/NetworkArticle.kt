package com.ekstrlabs.newsapplication.data.network.entities

import com.google.gson.annotations.SerializedName

data class NetworkArticle(

    val id: Int,
    val title: String,
    val description: String,

    @SerializedName("image")
    val imageUrl: String,

    val categories: List<String>

)
