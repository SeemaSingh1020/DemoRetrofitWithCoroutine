package com.demoretrofitwithcoroutine.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demoretrofitwithcoroutine.model.UserDetails
import com.demoretrofitwithcoroutine.networking.MainRepository
import com.demoretrofitwithcoroutine.networking.NetworkHelper
import com.demoretrofitwithcoroutine.networking.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {
    private val _users = MutableLiveData<NetworkResult<UserDetails>>()
    val userData: LiveData<NetworkResult<UserDetails>> = _users

    /*  private val _usersf = MutableSharedFlow<NetworkResult<UserDetails>>()
      val userDatad: Flow<NetworkResult<UserDetails>> = _usersf.asSharedFlow()*/

    init {
        fetchUsers()
        ArrayList<String>()
    }

    private fun fetchUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            _users.postValue(NetworkResult.Loading())
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getUsers().let {
                    if (it.isSuccessful) {
                        _users.postValue(NetworkResult.Success(it.body()!!))
                    } else _users.postValue(NetworkResult.Error(it.errorBody().toString(), null))
                }
            } else _users.postValue(NetworkResult.Error("No internet connection", null))
        }
    }
}