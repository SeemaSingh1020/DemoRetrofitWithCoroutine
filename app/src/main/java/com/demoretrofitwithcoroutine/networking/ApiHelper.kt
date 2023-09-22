package com.demoretrofitwithcoroutine.networking

import com.demoretrofitwithcoroutine.model.UserDetails
import retrofit2.Response

interface ApiHelper {
    suspend fun getUsers(): Response<UserDetails>
}