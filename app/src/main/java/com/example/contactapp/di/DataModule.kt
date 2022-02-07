package com.example.contactapp.di

import com.example.contactapp.data.datasource.RetrofitDataSource
import com.example.contactapp.data.datasource.UserDataSource
import com.example.contactapp.data.repository.UserRepository
import com.example.contactapp.data.repository.UserRepositoryInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Singleton
    @Binds
    abstract fun bindUserRepository(
        userRepository: UserRepository
    ): UserRepositoryInterface

    @Singleton
    @Binds
    abstract fun bindUserDataSource(
        userDataSource: RetrofitDataSource
    ): UserDataSource
}