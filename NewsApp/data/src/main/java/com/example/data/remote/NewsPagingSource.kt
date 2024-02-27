package com.example.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.mappers.toDomain
import com.example.domain.model.Article

class NewsPagingSource (
    private val api: NewsApi,
    private val sources: String
): PagingSource<Int, Article>() {

    private var totalNewsCount = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1
        return try {
            val response = api.getNews(
                page = page,
                sources = sources
            ).body()
            totalNewsCount += response?.articles?.size ?: 0
            val articles = response?.toDomain()?.distinctBy { it.title } ?: emptyList()
            LoadResult.Page(
                data = articles,
                nextKey = if(totalNewsCount == response?.totalResults) null else page + 1,
                prevKey = null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(throwable = e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let {  anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

}