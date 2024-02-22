package com.example.domain.repository

import com.example.common.Resource
import com.example.domain.model.Blog

interface GetPagerBlogsRepository {

    suspend fun getPagerBlogs(page: Int, limit: Int): Resource<List<Blog>>

}