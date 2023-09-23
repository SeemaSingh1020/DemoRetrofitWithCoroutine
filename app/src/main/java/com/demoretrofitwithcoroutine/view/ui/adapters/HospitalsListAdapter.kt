package com.demoretrofitwithcoroutine.view.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demoretrofitwithcoroutine.databinding.ItemHospitalsListBinding
import com.demoretrofitwithcoroutine.model.NearHospitalsList

class HospitalsListAdapter(private val hospitalList: List<NearHospitalsList>) :
    RecyclerView.Adapter<HospitalListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalListViewHolder {
        val binding =
            ItemHospitalsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HospitalListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HospitalListViewHolder, position: Int) {
        with(holder.binding) {
            with(hospitalList[position]) {
                txtHospitalsName.text = hospitalName
                txtContactPerson.text = contactPerson
                txtCallOn.text = number
                txtKm.text = distance
            }

        }
    }

    override fun getItemCount() = hospitalList.size


}