package com.demoretrofitwithcoroutine.viewmodels

import androidx.lifecycle.ViewModel
import com.demoretrofitwithcoroutine.model.NearHospitalsList
import com.demoretrofitwithcoroutine.networking.RetrofitHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class HospitalsListViewModel @Inject constructor() : ViewModel() {

    /*  fun getHospitalsData(): LiveData<Hospital> {
          return MutableLiveData<Hospital>().apply {
              viewModelScope.launch(Dispatchers.IO) {
                  val response = RetrofitHelper.getRepository().getHospitalData()

                  withContext(Dispatchers.Main) {
                      if (response.isSuccessful) {

                          val nearHospitalsList = response.body()
                          value = nearHospitalsList!!
                      } else {
                          val error = response.errorBody()
                      }
                  }

              }
          }

      }*/
    fun getHospitalsData(): Flow<List<NearHospitalsList>> {
        return flow {
            val response = RetrofitHelper.getRepository().getHospitalData()
            if (response.isSuccessful) {
                val nearHospitalsList = response.body()
                emit(nearHospitalsList!!)
            } else {
                val error = response.errorBody()
            }

        }.flowOn(Dispatchers.IO)
    }

}