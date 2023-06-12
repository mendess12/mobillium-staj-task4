package com.example.task4.ui.detail

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.task4.dao.CryptoDatabase
import com.example.task4.di.RetrofitModule
import com.example.task4.model.CryptoDetail
import com.example.task4.model.CryptoListItem
import com.example.task4.util.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val retrofitModule: RetrofitModule,
    application: Application
) : BaseViewModel(application) {

    val cryptoDataDetail = MutableLiveData<CryptoDetail?>()
    private val cryptoDataRoom = MutableLiveData<CryptoListItem>()

    fun cryptoDetailDataFromAPI(cryptoId: String) {
        viewModelScope.launch {
            val response = retrofitModule.retrofitBuilder().getCryptoDetailData(cryptoId)
            if (response.isSuccessful) {
                cryptoDataDetail.value = response.body()
            } else {
                cryptoDataDetail.value = null
            }
        }
    }

    fun getDataFromRoom(uuid: Int) {
        launch {
            val dao = CryptoDatabase(getApplication()).cryptoDao()
            val crypto = dao.getOneCrypto(uuid)
            cryptoDataRoom.value = crypto

        }
    }

}