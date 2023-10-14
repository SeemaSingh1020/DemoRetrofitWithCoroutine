package com.neardoctor.view.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neardoctor.databinding.ItemAmbulanceListBinding
import com.neardoctor.model.NearAmbulanceList

class AmbulanceListAdapter(private val ambulanceList: List<NearAmbulanceList>) :
    RecyclerView.Adapter<AmbulanceListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmbulanceListViewHolder {
        val binding =
            ItemAmbulanceListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AmbulanceListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AmbulanceListViewHolder, position: Int) {
        with(holder.binding){
            with(ambulanceList[position]){
                txtAmbulanceDriver.text = driveName
                    txtAmbulanceContact.text = number
                    txtAmbulanceCharge.text = charge
                    txtAmbulanceDistance.text = distance
            }
        }

    }

    override fun getItemCount() = ambulanceList.size


}