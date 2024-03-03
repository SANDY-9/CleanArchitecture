package com.example.data.di

import android.content.Context
import com.example.common.BASE_URL
import com.example.data.remote.NewsApi
import com.example.data.repository.NewsRepositoryImpl
import com.example.domain.manager.LocalUserManagerImpl
import com.example.domain.manager.LocalUserManager
import com.example.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Singleton
    @Provides
    fun provideLocalUserManager(@ApplicationContext context: Context): LocalUserManager {
        return LocalUserManagerImpl(context)
    }

    @Singleton
    @Provides
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Singleton
    @Provides
    fun provideNewsRepository(api: NewsApi): NewsRepository {
        return NewsRepositoryImpl(api)
    }

}