package com.demoretrofitwithcoroutine.model

import com.google.gson.annotations.SerializedName


data class NearDoctorAtHomeList (

    @SerializedName("doctor_name" ) var doctorName : String? = null,
    @SerializedName("number"      ) var number     : String? = null,
    @SerializedName("expriance"   ) var expriance  : String? = null,
    @SerializedName("degree"      ) var degree     : String? = null

)
