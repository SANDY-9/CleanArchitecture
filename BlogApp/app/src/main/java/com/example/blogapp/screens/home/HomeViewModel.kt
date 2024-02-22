package com.example.blogapp.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.common.Resource
import com.example.data.paging.BlogRemoteMediator
import com.example.data.room.BlogDAO
import com.example.domain.repository.GetPagerBlogsRepository
import com.example.domain.use_case.GetBlogsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getBlogsUseCase: GetBlogsUseCase,
    private val getPagerBlogsRepository: GetPagerBlogsRepository,
    private val blogDAO: BlogDAO
): ViewModel() {

    @OptIn(ExperimentalPagingApi::class)
    val pager = Pager(
        config = PagingConfig(pageSize = 10, prefetchDistance = 5),
        remoteMediator = BlogRemoteMediator(
            getPagerBlogsRepo = getPagerBlogsRepository,
            blogDAO = blogDAO
        )
    ) {
        blogDAO.getAllBlogItems()
    }.flow.cachedIn(viewModelScope)

    /*private val _blogs = mutableStateOf(HomeState())
    val blogs: State<HomeState> = _blogs

    init {
        getBlogs()
    }

    private fun getBlogs() {
        getBlogsUseCase.invoke().onEach {
            when(it) {
                is Resource.Loading -> {
                    _blogs.value = HomeState(isLoading = true)
                }
                is Resource.Success -> {
                    _blogs.value = HomeState(data = it.data)
                }
                is Resource.Error -> {
                    _blogs.value = HomeState(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }*/

}