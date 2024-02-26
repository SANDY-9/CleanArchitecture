package com.example.data.repository

import com.example.data.mappers.toDomain
import com.example.data.network.ApiService
import com.example.data.network.utils.SafeApiRequest
import com.example.domain.model.Blog
import com.example.domain.model.Owner
import com.example.domain.repository.GetBlogsRepository
import javax.inject.Inject

class GetBlogsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): GetBlogsRepository, SafeApiRequest() {
    override suspend fun getBlogs(): List<Blog> {
        val response = safeApiRequest {
            apiService.getBlogs()
        }
        return response.data?.toDomain() ?: emptyList()
    }

    override suspend fun getBlogDetails(id: String): Blog {
        val response = safeApiRequest {
            apiService.getBlogDetails(id = id)
        }
        return Blog(
            id = response.id ?: "",
            image = response.image ?: "",
            likes = response.likes ?: 0,
            owner = response.owner?.toDomain() ?: Owner(
                firstName = "",
                id = "",
                lastName = "",
                picture = "",
                title = ""
            ),
            publishDate = response.publishDate ?: "",
            tags = response.tags ?: listOf(),
            text = response.text ?: ""
        )
    }
}