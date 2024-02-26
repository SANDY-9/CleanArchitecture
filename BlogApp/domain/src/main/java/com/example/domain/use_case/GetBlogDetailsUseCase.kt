package com.example.domain.use_case

import com.example.common.Resource
import com.example.domain.model.Blog
import com.example.domain.repository.GetBlogsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetBlogDetailsUseCase @Inject constructor(
    private val getBlogsRepository: GetBlogsRepository
) {

    operator fun invoke(id: String): Flow<Resource<Blog>> = flow {
        emit(Resource.Loading(""))
        try {
            val response = getBlogsRepository.getBlogDetails(id)
            emit(Resource.Success(data = response))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }
}