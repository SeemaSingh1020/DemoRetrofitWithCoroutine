package com.neardoctor.model

import com.google.gson.annotations.SerializedName


data class UserName(
    @SerializedName("name") var name: String? = null,
    @SerializedName("address") var address: String? = null

)

