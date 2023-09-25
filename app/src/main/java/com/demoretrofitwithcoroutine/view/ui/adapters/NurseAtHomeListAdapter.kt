package com.demoretrofitwithcoroutine.view.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demoretrofitwithcoroutine.databinding.ItemNurseAtHomeListBinding
import com.demoretrofitwithcoroutine.model.NearNurseAtHomeList

class NurseAtHomeListAdapter(private val nurseAtHomeList: List<NearNurseAtHomeList>) :
    RecyclerView.Adapter<NurseAtHomeListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NurseAtHomeListViewHolder {
        val binding =
            ItemNurseAtHomeListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NurseAtHomeListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NurseAtHomeListViewHolder, position: Int) {
        with(holder.binding) {
            with(nurseAtHomeList[position]) {
                txtNurseAtHomeName.text = nurseName
                txtNurseAtHomeContact.text = number
                txtNurseAtHomeYear.text = expriance
                txtNurseAtHomeDegree.text = degree

            }
        }
    }

    override fun getItemCount(): Int = nurseAtHomeList.size


}