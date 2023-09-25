package com.demoretrofitwithcoroutine.viewmodels

import androidx.lifecycle.ViewModel
import com.demoretrofitwithcoroutine.model.NearNurseAtHomeList
import com.demoretrofitwithcoroutine.networking.RetrofitHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel

class NurseAtHomeListViewModel @Inject constructor() : ViewModel() {

    fun getNurseAtHomeData(): Flow<List<NearNurseAtHomeList>> {
        return flow {
            val response = RetrofitHelper.getRepository().getNurseAtHomeData()
            if (response.isSuccessful) {
                val nearNurseAtHomeList = response.body()
                emit(nearNurseAtHomeList!!)
            } else {
                val error = response.errorBody()
            }

        }.flowOn(Dispatchers.IO)
    }
}