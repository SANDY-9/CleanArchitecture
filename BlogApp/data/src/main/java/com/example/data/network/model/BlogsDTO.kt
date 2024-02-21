package com.example.data.network.model


import com.google.gson.annotations.SerializedName

data class BlogsDTO(
    @SerializedName("data")
    val `data`: List<BlogDTO>,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("page")
    val page: Int,
    @SerializedName("total")
    val total: Int
)