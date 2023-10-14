package com.neardoctor.model

import com.google.gson.annotations.SerializedName


data class NearNurseAtHomeList (

    @SerializedName("nurse_name" ) var nurseName : String? = null,
    @SerializedName("number"     ) var number    : String? = null,
    @SerializedName("expriance"  ) var expriance : String? = null,
    @SerializedName("degree"     ) var degree    : String? = null

)
