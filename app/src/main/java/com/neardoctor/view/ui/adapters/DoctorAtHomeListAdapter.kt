package com.neardoctor.view.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neardoctor.databinding.ItemDoctorAtHomeListBinding
import com.neardoctor.model.NearDoctorAtHomeList

class DoctorAtHomeListAdapter(private val doctorAtHomeList: List<NearDoctorAtHomeList>) :
    RecyclerView.Adapter<DoctorAtHomeListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorAtHomeListViewHolder {
        val binding =
            ItemDoctorAtHomeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DoctorAtHomeListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DoctorAtHomeListViewHolder, position: Int) {
        with(holder.binding) {
            with(doctorAtHomeList[position]) {
                txtDoctorAtHomeName.text = doctorName
                txtDoctorAtHomeContact.text = number
                txtDoctorAtHomeYear.text = expriance
                txtDoctorAtHomeDegree.text = degree

            }
        }
    }

    override fun getItemCount() = doctorAtHomeList.size
}