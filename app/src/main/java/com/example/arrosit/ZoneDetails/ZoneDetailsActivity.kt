package com.example.arrosit.ZoneDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.arrosit.R
import com.example.arrosit.databinding.ActivityZoneDetailsBinding

class ZoneDetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivityZoneDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityZoneDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val zoneName = intent.extras?.getString("zoneName")
        val zoneSize = intent.extras?.getString("zoneSize")

        binding.textViewZoneName.text = zoneName.toString()

        binding.textViewZoneSize.text = zoneSize.toString()

        object :CountDownTimer(300000 ,1000)
        {
            override fun onTick(millisUntilFinished: Long) {
                binding.textViewMinutes.text = "${millisUntilFinished / 10000}"
            }

            override fun onFinish() {
                binding.textViewMinutes.text = "0"
            }

        }.start()

    }
}