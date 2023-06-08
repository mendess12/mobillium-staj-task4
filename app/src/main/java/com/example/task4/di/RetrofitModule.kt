package com.example.task4.di

import com.example.task4.service.CryptoAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
open class RetrofitModule @Inject constructor() {

    @Provides
    @Singleton
    fun retrofitBuilder(): CryptoAPI = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient())
        .build()
        .create(CryptoAPI::class.java)

    companion object {
        const val BASE_URL = "https://api.coingecko.com/api/v3/"
    }
}