package com.demoretrofitwithcoroutine.view.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.demoretrofitwithcoroutine.model.HomeData
import com.demoretrofitwithcoroutine.model.HomeDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var homeDataRepository: HomeDataRepository
    // normal way without hilt
   /* fun getData(): LiveData<List<HomeData>> {
        return MutableLiveData<List<HomeData>>().apply {
            val homeDataRepository = HomeDataRepository()
            val dataList = homeDataRepository.getHomeData()
            value = dataList
        }

    }*/
    // with hilt
    fun getData(): LiveData<List<HomeData>> {
        return MutableLiveData<List<HomeData>>().apply {
            val dataList = homeDataRepository.getHomeData()
            value = dataList
        }

    }
}