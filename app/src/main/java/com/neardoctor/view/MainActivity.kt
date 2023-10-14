package com.neardoctor.view

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.neardoctor.R
import com.neardoctor.databinding.ActivityMainBinding
import com.neardoctor.viewmodels.MainViewModel
import com.neardoctor.viewmodels.MyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val myViewModel: MyViewModel by viewModels()
    private val d: MainViewModel by viewModels()
   //private val myViewModel:MyViewModel by lazy { ViewModelProvider(this)[MyViewModel::class.java] }
    private lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // binding
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //dail- call
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "8285821932"))
        startActivity(intent)
        dialog = createDialog()
        binding.btnClickMe.setOnClickListener {
        /*    simple().forEach { value ->
                Toast.makeText(
                    this@MainActivity,
                    value.toString(),
                    Toast.LENGTH_LONG
                ).show()
            }*/

             showProgress()
            // myViewModel.getUserData()
          myViewModel.getData()
        }
        // live Data Call
        myViewModel.userData.observe(this) {
            it.run {
                Toast.makeText(
                    this@MainActivity,
                    "Name : $name address :$address",
                    Toast.LENGTH_LONG
                ).show()
                hideProgress()
            }
            // Toast.makeText(this@MainActivity,"Name : "+it.name+" address :"+it.address,Toast.LENGTH_LONG).show()
        }

    }

    fun simple(): Sequence<Int> = sequence { // sequence builder
        for (i in 1..3) {
            Thread.sleep(10000) // pretend we are computing it
            yield(i) // yield next value
        }
    }


    private fun createDialog(): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setCancelable(false) // if you want user to wait for some process to finish,
        builder.setView(R.layout.progress_dialog)
        return builder.create()
    }

    private fun showProgress() {
        dialog.show()
    }

    private fun hideProgress() {
        dialog.dismiss()
    }
}