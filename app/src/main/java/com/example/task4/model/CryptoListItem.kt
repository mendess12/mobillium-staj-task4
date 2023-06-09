package com.example.task4.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class CryptoListItem(
    @ColumnInfo(name = "country")
    val country: String? = null,
    @ColumnInfo(name = "description")
    val description: String? = null,
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "trade_volume_24h_btc")
    @SerializedName("trade_volume_24h_btc")
    val tradeVolume: Double,
    @ColumnInfo(name = "trade_volume_24h_btc_normalized")
    @SerializedName("trade_volume_24h_btc_normalized")
    val tradeVolumeNormalized: Double,
    @ColumnInfo(name = "trust_score")
    @SerializedName("trust_score")
    val trustScore: Int,
    @ColumnInfo(name = "trust_score_rank")
    @SerializedName("trust_score_rank")
    val trustScoreRank: Int,
    @ColumnInfo(name = "year_established")
    @SerializedName("year_established")
    val yearEstablished: Int
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0
}