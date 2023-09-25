package com.demoretrofitwithcoroutine.model

import com.google.gson.annotations.SerializedName


data class NearAmbulanceList (

    @SerializedName("drive_name" ) var driveName : String? = null,
    @SerializedName("number"     ) var number    : String? = null,
    @SerializedName("charge"     ) var charge    : String? = null,
    @SerializedName("distance"   ) var distance  : String? = null

)
