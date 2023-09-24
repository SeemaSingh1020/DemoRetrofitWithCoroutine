package com.demoretrofitwithcoroutine.viewmodels

import androidx.lifecycle.ViewModel
import com.demoretrofitwithcoroutine.model.NearHospitalsList
import com.demoretrofitwithcoroutine.model.NearPharmacyList
import com.demoretrofitwithcoroutine.networking.RetrofitHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class PharmacyListViewModel @Inject constructor() : ViewModel() {


    fun getPharmacyData(): Flow<List<NearPharmacyList>> {
        return flow {
            val response = RetrofitHelper.getRepository().getPharmacyData()
            if (response.isSuccessful) {
                val nearPharmacyList = response.body()
                emit(nearPharmacyList!!)
            } else {
                val error = response.errorBody()
            }

        }.flowOn(Dispatchers.IO)
    }
}
