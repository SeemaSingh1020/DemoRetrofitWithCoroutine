package com.demoretrofitwithcoroutine.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.demoretrofitwithcoroutine.databinding.ActivityDoctorListBinding
import com.demoretrofitwithcoroutine.view.ui.adapters.DoctorListAdapter
import com.demoretrofitwithcoroutine.viewmodels.DoctorListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DoctorListActivity : AppCompatActivity() {

    /*private val myViewModel: DoctorListViewModel by lazy {
        ViewModelProvider(this)[DoctorListViewModel::class.java]
    }*/
    private val myViewModel: DoctorListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDoctorListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myViewModel.getDoctorData()
        binding.recycleDoctorList.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        myViewModel.doctorList.observe(this) {
            binding.recycleDoctorList.adapter= DoctorListAdapter(it.doctorList)
        }

    }
}