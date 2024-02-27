package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(sources: List<String>): Flow<PagingData<Article>>

}