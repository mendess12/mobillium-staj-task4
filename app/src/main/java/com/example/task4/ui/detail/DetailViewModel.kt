package com.example.task4.ui.detail

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.task4.dao.CryptoDatabase
import com.example.task4.di.RetrofitModule
import com.example.task4.model.CryptoDetail
import com.example.task4.model.CryptoListItem
import com.example.task4.util.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val retrofitModule: RetrofitModule,
    application: Application
) : BaseViewModel(application) {

    val cryptoDataDetail = MutableLiveData<CryptoDetail?>()
    private val cryptoDataRoom = MutableLiveData<CryptoListItem>()

    var job: Job? = null
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Toast.makeText(getApplication(), throwable.localizedMessage, Toast.LENGTH_LONG).show()
    }

    fun cryptoDetailDataFromAPI(cryptoId: String) {
        job = viewModelScope.launch(Dispatchers.IO + exceptionHandler) {
            val response = retrofitModule.retrofitBuilder().getCryptoDetailData(cryptoId)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    cryptoDataDetail.value = response.body()
                } else {
                    cryptoDataDetail.value = null
                }
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

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}