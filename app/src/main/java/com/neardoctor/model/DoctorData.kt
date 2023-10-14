package com.neardoctor.model

import com.google.gson.annotations.SerializedName


data class DoctorData(
    @SerializedName("doctorList") var doctorList: ArrayList<NearDoctorList> = arrayListOf()
)

