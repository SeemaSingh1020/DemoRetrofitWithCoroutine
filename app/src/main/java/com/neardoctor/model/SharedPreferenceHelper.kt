package com.neardoctor.model

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class SharedPreferenceHelper @Inject constructor() {
    @Inject
    lateinit var sharedPreferences: SharedPreferences
    private val gson by lazy { Gson() }
    private val appointment = "doctor_appointment"
    fun saveDoctorAppointment(doctorDetails: NearDoctorList) {
        var listOfNearDoctorList = getDoctorAppointment()
        if (listOfNearDoctorList == null) {
            listOfNearDoctorList = arrayListOf()
        }
        listOfNearDoctorList.add(doctorDetails)
        val json = gson.toJson(listOfNearDoctorList)
        val editor = sharedPreferences.edit()
        editor.putString(appointment, json)
        editor.apply()

    }
    /**
     * Retrieves the doctor appointment details from SharedPreferences.
     *
     * @return An ArrayList of NearDoctorList or null if the data is not available.
     */

    fun getDoctorAppointment(): ArrayList<NearDoctorList>? {
        val doctorAppointmentDetail = sharedPreferences.getString(appointment, "")
        return doctorAppointmentDetail?.let {
            val type = object : TypeToken<ArrayList<NearDoctorList>>() {}.type
            gson.fromJson(it, type)
        }
    }

}