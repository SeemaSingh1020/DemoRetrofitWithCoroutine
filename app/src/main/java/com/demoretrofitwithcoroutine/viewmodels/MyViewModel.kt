package com.demoretrofitwithcoroutine.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demoretrofitwithcoroutine.model.DemoUser
import com.demoretrofitwithcoroutine.model.UserDetails
import com.demoretrofitwithcoroutine.model.UserDetails2
import com.demoretrofitwithcoroutine.model.UserName
import com.demoretrofitwithcoroutine.networking.RetrofitHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class MyViewModel @Inject constructor() : ViewModel() {
    private var _userData = MutableLiveData<UserName>()
    val userData: LiveData<UserName> = _userData

    // 1 method - LiveData

    fun getUserData() {
        // coroutine code
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitHelper.getRepository().getUserName()
            // Different thread in the liveData
            // we are using post value
            /* if (response.isSuccessful) {
                 val userName = response.body()
                 _userData.postValue(userName)
             }*/

            // Same thread in liveData
            // set value
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val userName = response.body()!!
                    _userData.value = userName
                } else {
                    val error = response.errorBody()
                }
            }
        }

    }

    // 2 Method   Flow

    fun getData() {
        viewModelScope.launch {
            // we are using flow
            getUserData1()
                .catch {
                }
                // If Api call is succeeded, set the State to Success
                // and set the response data to data received from api
                .collect {
                    withContext(Dispatchers.Main) {
                        _userData.value = it
                    }

                }
        }
    }

    private var _userDetails = MutableLiveData<UserDetails>()
    val userDetails: LiveData<UserDetails> = _userDetails
    fun getUserData2() {
        viewModelScope.launch {
            getUserDetails().catch {
            }.collect {
                withContext(Dispatchers.Main) {
                    _userDetails.value = it
                }
            }
        }
    }

    private var userDetails2 = MutableLiveData<UserDetails2>()
    val userDetail: LiveData<UserDetails2> = userDetails2
    fun getUserData3() {
        viewModelScope.launch {
            getUserDetails2().catch {
            }.collect() {
                withContext(Dispatchers.Main) {
                    userDetails2.value = it
                }
            }
        }
    }

    private fun getUserData1(): Flow<UserName> = flow {
        val data = RetrofitHelper.getRepository().getUserName()
        if (data.isSuccessful) {
            data.body()?.let { emit(it) }
        }
    }.flowOn(Dispatchers.IO)


    private fun getUserDetails(): Flow<UserDetails> = flow {
        val userDetails = RetrofitHelper.getRepository().getUserDetails()
        if (userDetails.isSuccessful) {
            userDetails.body()?.let { emit(it) }
        }
    }.flowOn(Dispatchers.IO)

    private fun getUserDetails2(): Flow<UserDetails2> = flow {
        val userDetails2 = RetrofitHelper.getRepository().getUserDetails2()
        if (userDetails2.isSuccessful) {
            userDetails2.body()?.let { emit(it) }
        }
    }.flowOn(Dispatchers.IO)

// 3 Method

    // without coroutines

    private var _userData1 = MutableLiveData<UserName>()
    public val userData1: LiveData<UserName> = _userData1

    public fun getD() {
        // only using retrofit and gson-
        RetrofitHelper.getRepository().getUserNameDemo().enqueue(object :
            Callback<UserName> {
            override fun onResponse(call: Call<UserName>, response: Response<UserName>) {
                if (response.isSuccessful) {
                    val userName: UserName = response.body()!!
                    _userData1.value = userName
                }
            }

            override fun onFailure(call: Call<UserName>, t: Throwable) {

            }

        })
    }

    val _data = MutableLiveData<DemoUser>()
    val data1: LiveData<DemoUser> = _data
    fun myData() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitHelper.getRepository().getJavaTutorials()
            if (response.isSuccessful) {
                withContext(Dispatchers.Main) {
                    val data2 = response.body()!!
                    _data.value = data2
                }
            } else {
                val error = response.errorBody()
            }

        }

    }


    fun getDemo() {
        viewModelScope.launch(Dispatchers.IO) {
            getUserData22()
                .catch { }
                .collect {
                    _data.value = it
                }
        }

    }

    fun getUserData22(): Flow<DemoUser> = flow {
        // setting the base url
        //  RetrofitHelper.setUrl("www.javatpoint.com")
        val d = RetrofitHelper.getRepository().getJavaTutorials()
        if (d.isSuccessful) {
            withContext(Dispatchers.Main) {
                d.body()?.let { emit(it) }
            }

        }
    }.flowOn(Dispatchers.IO)

}

