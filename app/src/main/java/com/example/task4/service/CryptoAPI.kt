package com.example.task4.service

import com.example.task4.model.CryptoDetail
import com.example.task4.model.CryptoListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoAPI {

    @GET("exchanges")
    suspend fun getCryptoListData(): Response<List<CryptoListItem>>

    @GET("exchanges/{id}")
    suspend fun getCryptoDetailData(@Path("id") id: String): Response<CryptoDetail>
}