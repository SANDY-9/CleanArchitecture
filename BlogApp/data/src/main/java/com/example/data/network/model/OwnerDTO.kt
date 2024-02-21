package com.example.data.network.model


import com.google.gson.annotations.SerializedName

data class OwnerDTO(
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("picture")
    val picture: String,
    @SerializedName("title")
    val title: String
)