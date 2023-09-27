package com.demoretrofitwithcoroutine.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demoretrofitwithcoroutine.R
import com.demoretrofitwithcoroutine.databinding.ActivityMedicalHistoryBinding

class MedicalHistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMedicalHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}