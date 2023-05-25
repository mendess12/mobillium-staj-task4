package com.example.task4.service

import com.example.task4.model.CryptoDetail
import com.example.task4.model.CryptoListItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoAPI {

    @GET("exchanges")
    fun getCryptoListData(): Call<List<CryptoListItem>>

    @GET("exchanges/{id}")
    fun getCryptoDetailData(@Path("id") id: String): Call<CryptoDetail>
}