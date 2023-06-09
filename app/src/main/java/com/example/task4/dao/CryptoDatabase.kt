package com.example.task4.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.task4.model.CryptoListItem

@Database(entities = arrayOf(CryptoListItem::class), version = 1)
abstract class CryptoDatabase : RoomDatabase() {

    abstract fun cryptoDao(): CryptoDao

    //singleton
    //volatile -> tanımlanan değişken farklı thread'lerde görünür hale getirir
    companion object {

        @Volatile
        private var instance: CryptoDatabase? = null

        //instance var mı yok mu kontrol eder
        //synchronized -> iki thread'in aynı anda objeye ulaşmasını engeller
        private val lock = Any()
        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: makeDatabase(context).also {
                instance = it
            }
        }

        private fun makeDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            CryptoDatabase::class.java,
            "cryptoDatabase"
        ).build()
    }
}