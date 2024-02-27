package com.example.data.remote.model


import com.google.gson.annotations.SerializedName

data class ArticlesDTO(
    @SerializedName("articles")
    val articles: List<ArticleDTO>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)