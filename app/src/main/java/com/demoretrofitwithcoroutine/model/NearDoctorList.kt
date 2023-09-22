package com.demoretrofitwithcoroutine.model

import com.google.gson.annotations.SerializedName


data class NearDoctorList (

    @SerializedName("name"       ) var name       : String? = null,
    @SerializedName("experience" ) var experience : String? = null,
    @SerializedName("degree"     ) var degree     : String? = null

)