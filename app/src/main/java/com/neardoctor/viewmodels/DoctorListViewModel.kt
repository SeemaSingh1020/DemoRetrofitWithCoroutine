package com.neardoctor.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neardoctor.model.DoctorData
import com.neardoctor.networking.RetrofitHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DoctorListViewModel @Inject constructor() : ViewModel() {
    private var _doctorList = MutableLiveData<DoctorData>()
    val doctorList: LiveData<DoctorData> = _doctorList


    fun getDoctorData() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitHelper.getRepository().getDoctorData()

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val doctorList = response.body()!!
                    _doctorList.value = doctorList
                } else {
                    val error = response.errorBody()
                }
            }

        }

    }


}


