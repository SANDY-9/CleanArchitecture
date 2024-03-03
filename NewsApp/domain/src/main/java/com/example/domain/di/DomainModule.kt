package com.example.domain.di

import com.example.domain.manager.LocalUserManager
import com.example.domain.repository.NewsRepository
import com.example.domain.usecases.app_entry.AppEntryUseCases
import com.example.domain.usecases.app_entry.ReadAppEntry
import com.example.domain.usecases.app_entry.SaveAppEntry
import com.example.domain.usecases.news.GetNewsUseCase
import com.example.domain.usecases.news.NewsUseCases
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
    fun provideAppEntryUseCases(localUserManager: LocalUserManager): AppEntryUseCases {
        return AppEntryUseCases(
            readAppEntry = ReadAppEntry(localUserManager),
            saveAppEntry = SaveAppEntry(localUserManager)
        )
    }

    @Singleton
    @Provides
    fun provideGetNewsCases(newsRepository: NewsRepository): GetNewsUseCase {
        return GetNewsUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun provideNewsCases(getNewsUseCase: GetNewsUseCase): NewsUseCases{
        return NewsUseCases(getNewsUseCase)
    }

}