package com.demoretrofitwithcoroutine.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demoretrofitwithcoroutine.databinding.ActivityEmergencyHelpBinding

class EmergencyHelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityEmergencyHelpBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}