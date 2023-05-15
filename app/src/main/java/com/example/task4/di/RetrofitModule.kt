package com.example.task4.di

import com.example.task4.model.CryptoListItem
import com.example.task4.service.CryptoAPI
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitModule {

    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient())
        .build()
        .create(CryptoAPI::class.java)

    fun getListData(): Call<List<CryptoListItem>> {
        return retrofitBuilder.getCryptoListData()
    }

    companion object {
        const val BASE_URL = "https://api.coingecko.com/api/v3/"
    }
}