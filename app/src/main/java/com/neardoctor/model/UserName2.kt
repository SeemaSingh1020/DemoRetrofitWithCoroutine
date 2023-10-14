package com.neardoctor.model

import com.google.gson.annotations.SerializedName


data class UserDetails2 (

    @SerializedName("name"    ) var name    : String? = null,
    @SerializedName("age"     ) var age     : Int?    = null,
    @SerializedName("address" ) var address : String? = null,
    @SerializedName("pincode" ) var pincode : Int?    = null,
    @SerializedName("mob"     ) var mob     : Int?    = null,
    @SerializedName("gender"  ) var gender  : String? = null,
    @SerializedName("collage" ) var collage : String? = null

)