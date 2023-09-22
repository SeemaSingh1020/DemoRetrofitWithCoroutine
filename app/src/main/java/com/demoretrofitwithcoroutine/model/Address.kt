package com.demoretrofitwithcoroutine.model

import com.google.gson.annotations.SerializedName


data class Address (

    @SerializedName("dist"    ) var dist    : String? = null,
    @SerializedName("state"   ) var state   : String? = null,
    @SerializedName("pincode" ) var pincode : Int?    = null

)
