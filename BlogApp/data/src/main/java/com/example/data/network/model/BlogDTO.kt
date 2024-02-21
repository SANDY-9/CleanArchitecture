package com.example.data.network.model


import com.google.gson.annotations.SerializedName

data class BlogDTO(
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("likes")
    val likes: Int,
    @SerializedName("owner")
    val owner: OwnerDTO,
    @SerializedName("publishDate")
    val publishDate: String,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("text")
    val text: String
)