package com.example.domain.di

import com.example.domain.manager.LocalUserManager
import com.example.domain.use_cases.AppEntryUseCases
import com.example.domain.use_cases.ReadAppEntry
import com.example.domain.use_cases.SaveAppEntry
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

}