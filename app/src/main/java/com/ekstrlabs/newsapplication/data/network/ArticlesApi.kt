package com.ekstrlabs.newsapplication.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class ArticlesApi {

    companion object {
        private const val baseUrl = "http://newsapplication.ekstrlabs.com/"

        val retrofit: ArticlesApiService
            get() {
                return Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ArticlesApiService::class.java)
            }
    }
}