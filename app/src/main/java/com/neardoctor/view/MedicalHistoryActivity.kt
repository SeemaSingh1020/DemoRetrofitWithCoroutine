package com.neardoctor.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neardoctor.databinding.ActivityMedicalHistoryBinding

class MedicalHistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMedicalHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}