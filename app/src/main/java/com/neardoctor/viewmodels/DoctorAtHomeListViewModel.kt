package com.neardoctor.viewmodels

import androidx.lifecycle.ViewModel
import com.neardoctor.model.NearDoctorAtHomeList
import com.neardoctor.networking.RetrofitHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel

class DoctorAtHomeListViewModel @Inject constructor() : ViewModel() {

    fun getDoctorAtHomeData(): Flow<List<NearDoctorAtHomeList>> {
        return flow {
            val response = RetrofitHelper.getRepository().getDoctorAtHomeData()
            if (response.isSuccessful) {
                val nearDoctorAtHomeList = response.body()
                emit(nearDoctorAtHomeList!!)
            } else {
                val error = response.errorBody()
            }

        }.flowOn(Dispatchers.IO)
    }
}