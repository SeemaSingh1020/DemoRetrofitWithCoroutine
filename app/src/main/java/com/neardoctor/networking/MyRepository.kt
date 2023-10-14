package com.neardoctor.networking

import com.neardoctor.model.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface MyRepository {
    @GET("v3/8b3142e8-9ae0-4697-a0b4-6075a765feff")
    suspend fun getUserName(): Response<UserName>

    @GET("/v3/ee3e7bad-db21-431c-97db-827140198c53")
    suspend fun getUserDetails(): Response<UserDetails>

    @GET("/v3/6eb1cf65-ac6d-4142-af63-907e4b535905")
    suspend fun getUserDetails2(): Response<UserDetails2>

    // retrofit only with gson
    @GET("v3/8b3142e8-9ae0-4697-a0b4-6075a765feff")
    fun getUserNameDemo(): Call<UserName>

    @GET("/java/object")
    suspend fun getJavaTutorials(): Response<DemoUser>

    @GET("/v3/1f208599-215e-452a-9ea0-35b6bdbd5388")
    suspend fun getDoctorData(): Response<DoctorData>

    @GET("v3/4b5532eb-ccd7-4cd3-aef8-49c54b5ca7e5")
    suspend fun getHospitalData(): Response<List<NearHospitalsList>>

    @GET("v3/7484e958-c142-408e-8473-b9ea9a9a6e7d")
    suspend fun getPharmacyData(): Response<List<NearPharmacyList>>

    @GET("v3/d5dfe135-a5aa-4e77-8e6f-8ea3b8a8e26e")
    suspend fun getAmbulanceData(): Response<List<NearAmbulanceList>>

    @GET("v3/82f04e08-7142-4b06-8743-83e031d84e11")
    suspend fun getDoctorAtHomeData(): Response<List<NearDoctorAtHomeList>>

    @GET("v3/0287bbee-6fe1-45b9-b506-0513be223ef8")
    suspend fun getNurseAtHomeData(): Response<List<NearNurseAtHomeList>>
}
