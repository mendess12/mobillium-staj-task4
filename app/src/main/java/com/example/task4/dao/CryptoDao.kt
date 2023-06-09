package com.example.task4.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.task4.model.CryptoListItem

@Dao
interface CryptoDao {
    //database access object
    @Insert
    suspend fun insertAll(vararg crypto: CryptoListItem): List<Long>

    @Query("SELECT * FROM cryptolistitem")
    suspend fun getAllCrypto(): List<CryptoListItem>

    @Query("SELECT * FROM cryptolistitem WHERE uuid = :cryptoUuid")
    suspend fun getOneCrypto(cryptoUuid: Int): CryptoListItem

    @Query("DELETE FROM cryptolistitem")
    suspend fun deleteAllCrypto()
}