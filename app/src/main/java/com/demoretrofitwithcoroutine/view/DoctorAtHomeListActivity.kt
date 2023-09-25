package com.demoretrofitwithcoroutine.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.demoretrofitwithcoroutine.databinding.ActivityDoctorAtHomeListBinding
import com.demoretrofitwithcoroutine.view.ui.adapters.DoctorAtHomeListAdapter
import com.demoretrofitwithcoroutine.viewmodels.DoctorAtHomeListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
@AndroidEntryPoint
class DoctorAtHomeListActivity : AppCompatActivity() {
    private val doctorAtHomeViewModel: DoctorAtHomeListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDoctorAtHomeListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerViewDoctorAtHomeList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        lifecycleScope.launch {
            doctorAtHomeViewModel.getDoctorAtHomeData().collect {
                binding.recyclerViewDoctorAtHomeList.adapter = DoctorAtHomeListAdapter(it)
            }
        }

    }
}