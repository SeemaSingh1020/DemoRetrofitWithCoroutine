package com.demoretrofitwithcoroutine.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.demoretrofitwithcoroutine.databinding.ActivityAmbulanceListBinding
import com.demoretrofitwithcoroutine.view.ui.adapters.AmbulanceListAdapter
import com.demoretrofitwithcoroutine.viewmodels.AmbulanceListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AmbulanceListActivity : AppCompatActivity() {
    private val ambulanceViewModel: AmbulanceListViewModel by viewModels<AmbulanceListViewModel>()
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAmbulanceListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerViewAmbulanceList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        lifecycleScope.launch {
            ambulanceViewModel.getAmbulanceData().collect {
                binding.recyclerViewAmbulanceList.adapter = AmbulanceListAdapter(it)
            }

        }

    }
}