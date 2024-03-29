package com.example.blogapp.screens.details

import com.example.domain.model.Blog

data class BlogDetailsStateHolder(
    val isLoading: Boolean = false,
    val data: Blog? = null,
    val error: String = ""
)
