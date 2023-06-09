package com.example.task4.ui.list

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.task4.dao.CryptoDatabase
import com.example.task4.di.RetrofitModule
import com.example.task4.model.CryptoListItem
import com.example.task4.util.BaseViewModel
import com.example.task4.util.CustomSharedPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val retrofitModule: RetrofitModule,
    application: Application
) : BaseViewModel(application) {

    val cryptoDataList = MutableLiveData<List<CryptoListItem>?>()
    private var customSharedPreferences = CustomSharedPreferences(getApplication())
    private var refreshTime = 10 * 60 * 1000 * 1000 * 1000L

    fun refreshData() {
        val updateTime = customSharedPreferences.getTime()
        if (updateTime != null && updateTime != 0L && System.nanoTime() - updateTime < refreshTime) {
            getDataFromSQLite()
        } else {
            getCryptoDataFromAPI()
        }

    }

    private fun getDataFromSQLite() {
        launch {
            val crypto = CryptoDatabase(getApplication()).cryptoDao().getAllCrypto()
            showCrypto(crypto)
            Toast.makeText(getApplication(), "Crypto data from SQLite", Toast.LENGTH_LONG).show()
        }
    }

    fun getCryptoDataFromAPI() {
        viewModelScope.launch {
            retrofitModule.retrofitBuilder().getCryptoListData().enqueue(
                object : Callback<List<CryptoListItem>> {
                    override fun onResponse(
                        call: Call<List<CryptoListItem>>,
                        response: Response<List<CryptoListItem>>
                    ) {
                        if (response.isSuccessful) {
                            response.body()?.let {
                                storeInSQLite(it)
                                Toast.makeText(
                                    getApplication(),
                                    "Crypto data from API",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        } else {
                            cryptoDataList.value = null
                        }
                    }

                    override fun onFailure(call: Call<List<CryptoListItem>>, t: Throwable) {
                        cryptoDataList.value = null
                        Log.d("Error message", t.printStackTrace().toString())
                    }
                })
        }
    }

    private fun showCrypto(cryptoList: List<CryptoListItem>) {
        cryptoDataList.value = cryptoList
    }

    private fun storeInSQLite(list: List<CryptoListItem>) {
        launch {
            val dao = CryptoDatabase(getApplication()).cryptoDao()
            dao.deleteAllCrypto()
            val listLong = dao.insertAll(*list.toTypedArray()) // list -> individual
            var i = 0
            while (i < list.size) {
                list[i].uuid = listLong[i].toInt()
                i++
            }
            showCrypto(list)
        }
        customSharedPreferences.saveTime(System.nanoTime())
    }
}