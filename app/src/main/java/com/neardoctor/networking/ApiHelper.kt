package com.neardoctor.networking

import com.neardoctor.model.UserDetails
import retrofit2.Response

interface ApiHelper {
    suspend fun getUsers(): Response<UserDetails>
}