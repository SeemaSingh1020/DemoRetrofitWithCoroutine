package com.demoretrofitwithcoroutine.view.ui.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.demoretrofitwithcoroutine.databinding.ItemHomeBinding
import com.demoretrofitwithcoroutine.model.HomeData
import com.demoretrofitwithcoroutine.view.*

class HomeAdapter(private val homeDataList: List<HomeData>) :
    RecyclerView.Adapter<HomeAdapterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapterViewHolder {
        val binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeAdapterViewHolder, position: Int) {
        //Option 1.Normal way
        // getting the data from list for given position
        /* val homeData = homeDataList[position]
         // setting thew title from home data
         holder.binding.txtTitle.text = homeData.title
         // setting the icon
         holder.binding.imgHomeItem.background = ContextCompat.getDrawable(context, homeData.resId)

         // Option 2.using with scope function
         with(holder) {
             val homeData = homeDataList[position]
             binding.txtTitle.text = homeData.title
             binding.imgHomeItem.background = ContextCompat.getDrawable(context, homeData.resId)
         }

         //Option  3
         with(holder) {
             with(homeDataList[position]) {
                 binding.apply {
                     txtTitle.text = title
                     imgHomeItem.background = ContextCompat.getDrawable(context, resId)
                 }

             }
         }
        //Option 4
        with(holder) {
            with(homeDataList[position]) {
                binding.txtTitle.text = title
                binding.imgHomeItem.background = ContextCompat.getDrawable(context, resId)
            }
        }*/
        // Option 5
        with(holder.binding) {
            with(homeDataList[position]) {
                txtTitle.text = title
                imgHomeItem.background = ContextCompat.getDrawable(root.context, resId)
            }
            row.setOnClickListener {
                if (position == 0) {
                    val intent = Intent(root.context, DoctorListActivity::class.java)
                    root.context.startActivity(intent)
                } else if (position == 1) {
                    val intent = Intent(root.context, HospitalsListActivity::class.java)
                    root.context.startActivity(intent)
                } else if (position == 2) {
                    val intent = Intent(root.context, PharmacyListActivity::class.java)
                    root.context.startActivity(intent)
                } else if (position == 3) {
                    val intent = Intent(root.context, AmbulanceListActivity::class.java)
                    root.context.startActivity(intent)
                } else if (position == 4) {
                    val intent = Intent(root.context, DoctorAtHomeListActivity::class.java)
                    root.context.startActivity(intent)
                } else if (position == 5) {
                    val intent = Intent(root.context, NurseAtHomeListActivity::class.java)
                    root.context.startActivity(intent)
                }


            }

        }

    }

    override fun getItemCount() = homeDataList.size

}
