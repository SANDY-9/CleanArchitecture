package com.example.data.remote

import com.example.common.API_KEY
import com.example.data.remote.model.ArticlesDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): Response<ArticlesDTO>

}