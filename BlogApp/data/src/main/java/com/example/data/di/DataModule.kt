package com.example.data.di

import android.content.Context
import androidx.room.RoomDatabase
import com.example.common.Constants.BASE_URL
import com.example.data.network.ApiService
import com.example.data.repository.GetBlogsRepositoryImpl
import com.example.data.repository.GetPagerBlogsRepoImpl
import com.example.data.room.BlogDAO
import com.example.data.room.BlogDatabase
import com.example.domain.repository.GetBlogsRepository
import com.example.domain.repository.GetPagerBlogsRepository
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
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideGetBlogsRepository(apiService: ApiService): GetBlogsRepository {
        return GetBlogsRepositoryImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): BlogDatabase {
        return BlogDatabase.getInstance(context)
    }

    @Singleton
    @Provides
    fun provideDAO(blogDatabase: BlogDatabase): BlogDAO {
        return blogDatabase.getBlogDAO()
    }

    @Singleton
    @Provides
    fun provideGetPagerBlogsRepository(apiService: ApiService): GetPagerBlogsRepository {
        return GetPagerBlogsRepoImpl(apiService)
    }

}