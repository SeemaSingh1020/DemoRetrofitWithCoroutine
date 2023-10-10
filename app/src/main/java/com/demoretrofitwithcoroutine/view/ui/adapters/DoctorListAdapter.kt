package com.demoretrofitwithcoroutine.view.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demoretrofitwithcoroutine.R
import com.demoretrofitwithcoroutine.databinding.ItemDoctorListBinding
import com.demoretrofitwithcoroutine.model.NearDoctorList
import com.demoretrofitwithcoroutine.model.SharedPreferenceHelper
import com.demoretrofitwithcoroutine.view.showMessage
import javax.inject.Inject


class DoctorListAdapter @Inject constructor(var sharedPreferenceHelper: SharedPreferenceHelper,var doctorList: List<NearDoctorList>) :
    RecyclerView.Adapter<DoctorListViewHolder>() {
    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorListViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDoctorListBinding.inflate(inflater, parent, false)
        return DoctorListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DoctorListViewHolder, position: Int) {
        // repeated so ignore it
        /*  holder.binding.txtName.text = doctorList[position].name
          holder.binding.txtDegree.text = doctorList[position].degree
  */
        // extra memory for variable so do not use
        /*  val binding = holder.binding
          val doctorDetail = doctorList[position]
          binding.txtName.text = doctorDetail.name*/

        with(holder.binding) {
            btnBookAppointment.setOnClickListener {
                context.showMessage(context.getString(R.string.appointment_booked))
                sharedPreferenceHelper.saveDoctorAppointment(doctorList[position])
            }
            with(doctorList[position]) {
                txtName.text = name
                txtYear.text = experience
                txtDegree.text = degree
            }
        }
    }

    override fun getItemCount(): Int {
        return doctorList.size
    }
}