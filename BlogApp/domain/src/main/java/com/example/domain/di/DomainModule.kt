package com.example.domain.di

import com.example.domain.repository.GetBlogsRepository
import com.example.domain.use_case.GetBlogsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Singleton
    @Provides
    fun provideGetBlogsUseCase(getBlogsRepository: GetBlogsRepository): GetBlogsUseCase {
      return GetBlogsUseCase(getBlogsRepository)
    }
}