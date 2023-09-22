package com.demoretrofitwithcoroutine.model

import com.demoretrofitwithcoroutine.R
import javax.inject.Inject

/**
 * A repository class for managing HomeData objects.
 *
 * This class serves as a repository for HomeData objects, providing methods to
 * retrieve, store, and manipulate data related to homes. It abstracts the underlying
 * data source, such as a database or an external API, and provides a high-level
 * interface for working with home-related data.
 *
 * Usage:
 * - Use the methods provided by this class to interact with HomeData objects.
 *
 * Example:
 * ```java
 * HomeDataRepository repository = new HomeDataRepository();
 * List<HomeData> homes = repository.getHomeData();
 * ```
 *
 * @constructor Creates a new instance of the HomeDataRepository.
 */
class HomeDataRepository @Inject constructor() {

    /**
     * Retrieves a list of HomeData objects.
     *
     * This function fetches a list of HomeData objects containing information about homes
     * from a data source, such as a database or an external API. The fetched data is returned
     * as a List of HomeData objects.
     *
     * @return A List of HomeData objects representing homes.
     */

    fun getHomeData(): List<HomeData> {
        return createDataForHome()
    }
    /**
     * Creates a list of HomeData objects.
     *
     * This function generates a list of HomeData objects containing information about homes.
     * The generated data can be used for various purposes, such as populating a user interface
     * with sample home information for testing and development.
     *
     * @return A List of HomeData objects representing homes.
     */
    private fun createDataForHome(): List<HomeData> {
        val homeDataList = ArrayList<HomeData>()
        val doctor = HomeData("Doctor", R.drawable.ic_doctor)
        homeDataList.add(doctor)
        val hospital = HomeData("Hospital", R.drawable.ic_hospitals)
        homeDataList.add(hospital)
        val pharmacy = HomeData("Pharmacy", R.drawable.ic_pharmacy)
        homeDataList.add(pharmacy)
        val ambulance = HomeData("Ambulance", R.drawable.ic_ambulance)
        homeDataList.add(ambulance)
        val doctorAtHome = HomeData("Doctor At Home", R.drawable.ic_doctor)
        homeDataList.add(doctorAtHome)
        val nurseAtHome = HomeData("Nurse At Home", R.drawable.ic_doctor)
        homeDataList.add(nurseAtHome)
        val medicalHistory = HomeData("Medical History", R.drawable.ic_doctor)
        homeDataList.add(medicalHistory)
        val emergencyHelp = HomeData("Emergency Help", R.drawable.ic_doctor)
        homeDataList.add(emergencyHelp)
        return homeDataList
    }

}