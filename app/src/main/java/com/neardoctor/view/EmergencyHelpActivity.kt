package com.neardoctor.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.neardoctor.databinding.ActivityEmergencyHelpBinding

class EmergencyHelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityEmergencyHelpBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}