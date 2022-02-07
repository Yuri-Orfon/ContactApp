package com.example.contactapp.di

import com.example.contactapp.data.service.UserService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun providePicPayService(): UserService {
        return Retrofit.Builder()
            .baseUrl("https://61f5796662f1e300173c4184.mockapi.io/api/v1/")
            .client(
                OkHttpClient.Builder()
                .build())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(UserService::class.java)
    }
}