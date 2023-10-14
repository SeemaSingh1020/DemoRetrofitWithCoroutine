package com.neardoctor.model

import com.google.gson.annotations.SerializedName


data class NearPharmacyList (

    @SerializedName("pharmacy_name"  ) var pharmacyName  : String? = null,
    @SerializedName("contact_person" ) var contactPerson : String? = null,
    @SerializedName("number"         ) var number        : String? = null,
    @SerializedName("distance"       ) var distance      : String? = null

)
