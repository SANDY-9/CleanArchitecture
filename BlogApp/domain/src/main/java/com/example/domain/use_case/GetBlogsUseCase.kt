package com.example.domain.use_case

import com.example.common.Resources
import com.example.domain.model.Blog
import com.example.domain.repository.GetBlogsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetBlogsUseCase @Inject constructor(
    private val getBlogsRepository: GetBlogsRepository
) {

    suspend operator fun invoke(): Flow<Resources<List<Blog>>> = flow {
        emit(Resources.Loading(null))
        try {
            val response = getBlogsRepository.getBlogs()
            emit(Resources.Success(data = response))
        } catch (e: Exception) {
            emit(Resources.Error("Network Error"))
        }
    }

}