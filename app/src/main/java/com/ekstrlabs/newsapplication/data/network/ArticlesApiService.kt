package com.ekstrlabs.newsapplication.data.network

import com.ekstrlabs.newsapplication.data.network.entities.NetworkArticlesWrapper
import retrofit2.http.GET


interface ArticlesApiService {

    @GET("articles.json")
    suspend fun getArticles(): NetworkArticlesWrapper

}