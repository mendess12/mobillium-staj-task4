package com.example.task4.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task4.di.RetrofitModule
import com.example.task4.model.CryptoDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val retrofitModule : RetrofitModule): ViewModel() {

    val cryptoDataDetail = MutableLiveData<CryptoDetail?>()

    fun cryptoDetailDataFromAPI(cryptoId: String) {
        viewModelScope.launch {
            retrofitModule.retrofitBuilder().getCryptoDetailData(cryptoId).enqueue(
                object : Callback<CryptoDetail> {
                    override fun onResponse(
                        call: Call<CryptoDetail>,
                        response: Response<CryptoDetail>
                    ) {
                        if (response.isSuccessful) cryptoDataDetail.value =
                            response.body() else cryptoDataDetail.value = null
                    }

                    override fun onFailure(call: Call<CryptoDetail>, t: Throwable) {
                        cryptoDataDetail.value = null
                    }

                }
            )
        }
    }
}