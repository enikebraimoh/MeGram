package com.example.android.eggtimernotifications.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.android.eggtimernotifications.R
import com.example.android.eggtimernotifications.databinding.ActivityIncomingCallBinding
import com.example.android.eggtimernotifications.databinding.FragmentEggTimerBinding
import com.example.android.eggtimernotifications.util.inComingCallNotification

class IncomingCallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_incoming_call)

        val binding: ActivityIncomingCallBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_incoming_call
        )

        val user = intent.extras?.get("caller_name")

        binding.caller.text = user.toString()
        
        binding.button.setOnClickListener {
            Toast.makeText(this, "answering the call...", Toast.LENGTH_SHORT).show()
        }
        
        binding.button2.setOnClickListener { 
            finish()
        }
    }




}