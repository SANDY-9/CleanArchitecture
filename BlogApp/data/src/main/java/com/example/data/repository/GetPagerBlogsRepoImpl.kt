package com.example.data.repository

import com.example.common.Resource
import com.example.data.mappers.toDomain
import com.example.data.network.ApiService
import com.example.domain.model.Blog
import com.example.domain.repository.GetPagerBlogsRepository
import javax.inject.Inject

class GetPagerBlogsRepoImpl @Inject constructor(
    private val apiService: ApiService
): GetPagerBlogsRepository {

    override suspend fun getPagerBlogs(page: Int, limit: Int): Resource<List<Blog>> {
        return try {
            val response = apiService.getBlogsPagination(page = page, limit = limit)
            if (response.isSuccessful) {
                val body = response.body()?.data?.toDomain()
                Resource.Success(body)

            } else {
                Resource.Error(response.errorBody()?.string())
            }

        } catch (e: Exception) {
            Resource.Error(e.localizedMessage)
        }
    }

}