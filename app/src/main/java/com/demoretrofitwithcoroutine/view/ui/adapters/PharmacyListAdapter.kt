package com.demoretrofitwithcoroutine.view.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demoretrofitwithcoroutine.databinding.ItemPharmacyListBinding
import com.demoretrofitwithcoroutine.model.NearPharmacyList

class PharmacyListAdapter(private val pharmacyList: List<NearPharmacyList>) :
    RecyclerView.Adapter<PharmacyListViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PharmacyListViewHolder {
        val binding = ItemPharmacyListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PharmacyListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PharmacyListViewHolder, position: Int) {
     with(holder.binding){
         with(pharmacyList[position]){
             txtPharmacyNamePharmacy.text = pharmacyName
             txtContactPersonPharmacy.text = contactPerson
             txtCallOnPharmacy.text = number
             txtKmPharmacy.text = distance
         }
     }
    }

    override fun getItemCount()= pharmacyList.size

}