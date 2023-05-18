package com.example.task4.ui.list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task4.di.RetrofitModule
import com.example.task4.model.CryptoListItem
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListViewModel : ViewModel() {

    private val retrofitModule = RetrofitModule()
    val cryptoDataList = MutableLiveData<List<CryptoListItem>?>()

    fun getCryptoDataFromAPI() {
        viewModelScope.launch {
            retrofitModule.retrofitBuilder.getCryptoListData().enqueue(
                object : Callback<List<CryptoListItem>> {
                    override fun onResponse(
                        call: Call<List<CryptoListItem>>,
                        response: Response<List<CryptoListItem>>
                    ) {
                        if (response.isSuccessful) cryptoDataList.value =
                            response.body() else cryptoDataList.value = null
                    }

                    override fun onFailure(call: Call<List<CryptoListItem>>, t: Throwable) {
                        cryptoDataList.value = null
                        Log.d("Error message", t.printStackTrace().toString())
                    }
                })
        }
    }
}