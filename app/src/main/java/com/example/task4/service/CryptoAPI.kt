package com.example.task4.service

import com.example.task4.model.CryptoDetailItem
import com.example.task4.model.CryptoListItem
import retrofit2.Call
import retrofit2.http.GET

interface CryptoAPI {

    @GET("exchanges/list")
    fun getCryptoListData(): Call<List<CryptoListItem>>

    @GET("exchanges")
    fun getCryptoDetailData(): Call<List<CryptoDetailItem>>
}