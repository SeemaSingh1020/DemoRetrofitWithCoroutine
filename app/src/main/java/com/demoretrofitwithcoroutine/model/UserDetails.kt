package com.demoretrofitwithcoroutine.model
import com.google.gson.annotations.SerializedName


data class UserDetails (

    @SerializedName("name"    ) var name    : String?  = null,
    @SerializedName("age"     ) var age     : Int?     = null,
    @SerializedName("address" ) var address : Address? = Address(),
    @SerializedName("mob"     ) var mob     : Int?     = null,
    @SerializedName("gender"  ) var gender  : String?  = null

)
