package com.neardoctor.view.ui.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.neardoctor.databinding.ItemHomeBinding
import com.neardoctor.model.HomeData
import com.neardoctor.view.*

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
                with(root.context) {
                    if (position == 0) {
                        //val inent= DoctorListActivity::class.java.getIntent( root.context)
                        // root.context.startActivity(inent)
                        startActivity(DoctorListActivity::class.java)
                    } else if (position == 1) {
                        startActivity(HospitalsListActivity::class.java)
                    } else if (position == 2) {
                        startActivity(PharmacyListActivity::class.java)
                    } else if (position == 3) {
                        val intent = Intent(root.context, AmbulanceListActivity::class.java)
                        startActivity(intent)
                    } else if (position == 4) {
                        val intent = Intent(root.context, DoctorAtHomeListActivity::class.java)
                        startActivity(intent)
                    } else if (position == 5) {
                        val intent = Intent(root.context, NurseAtHomeListActivity::class.java)
                        startActivity(intent)
                    } else if (position == 6) {
                        val intent = Intent(root.context, MedicalHistoryActivity::class.java)
                        startActivity(intent)
                    } else if (position == 7) {
                        val intent = Intent(root.context, EmergencyHelpActivity::class.java)
                        startActivity(intent)
                    }
                }


            }

        }


    }

    override fun getItemCount() = homeDataList.size


}
