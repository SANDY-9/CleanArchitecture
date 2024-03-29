package com.example.domain.repository

import com.example.domain.model.Blog

interface GetBlogsRepository {

    suspend fun getBlogs(): List<Blog>
    suspend fun getBlogDetails(id: String): Blog

}