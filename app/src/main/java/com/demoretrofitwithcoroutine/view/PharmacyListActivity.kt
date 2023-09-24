package com.demoretrofitwithcoroutine.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.demoretrofitwithcoroutine.databinding.ActivityPharmacyListBinding
import com.demoretrofitwithcoroutine.view.ui.adapters.PharmacyListAdapter
import com.demoretrofitwithcoroutine.viewmodels.PharmacyListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
@AndroidEntryPoint
class PharmacyListActivity : AppCompatActivity() {
    private val pharmacyViewModel: PharmacyListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPharmacyListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerViewPharmacyList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        lifecycleScope.launch {
            pharmacyViewModel.getPharmacyData().collect{
                binding.recyclerViewPharmacyList.adapter = PharmacyListAdapter(it)
            }
        }
    }
}