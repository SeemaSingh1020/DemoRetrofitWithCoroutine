package com.demoretrofitwithcoroutine.model

import com.google.gson.annotations.SerializedName


data class NearHospitalsList (

    @SerializedName("hospital_name"  ) var hospitalName  : String? = null,
    @SerializedName("contact_person" ) var contactPerson : String? = null,
    @SerializedName("number"         ) var number        : String? = null,
    @SerializedName("distance"       ) var distance      : String? = null

)
