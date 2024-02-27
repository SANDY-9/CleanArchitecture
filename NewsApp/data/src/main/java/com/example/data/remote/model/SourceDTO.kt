package com.example.data.remote.model


import com.google.gson.annotations.SerializedName

data class SourceDTO(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?
)