package com.example.task4.model

import com.google.gson.annotations.SerializedName

data class CryptoListItem(
    val country: String? = null,
    val description: String? = null,
    val id: String,
    val image: String,
    val name: String,
    @SerializedName("trade_volume_24h_btc")
    val tradeVolume: Double,
    @SerializedName("trade_volume_24h_btc_normalized")
    val tradeVolumeNormalized: Double,
    @SerializedName("trust_score")
    val trustScore: Int,
    @SerializedName("trust_score_rank")
    val trustScoreRank: Int,
    @SerializedName("year_established")
    val yearEstablished: Int
)