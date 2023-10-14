package com.neardoctor.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.neardoctor.databinding.ActivityHospitalsListBinding
import com.neardoctor.view.ui.adapters.HospitalsListAdapter
import com.neardoctor.viewmodels.HospitalsListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HospitalsListActivity : AppCompatActivity() {
    private val hospitalsViewModel: HospitalsListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHospitalsListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerViewHospitalsList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        lifecycleScope.launch {
            hospitalsViewModel.getHospitalsData().collect {
                binding.recyclerViewHospitalsList.adapter = HospitalsListAdapter(it)
            }

        }

    }
}