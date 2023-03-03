package com.example.arrosit.Main

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.arrosit.R
import com.example.arrosit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonHome.setOnClickListener {
            binding.iconHome.setImageResource(R.drawable.ic_home_selected)
            binding.iconMap.setImageResource(R.drawable.ic_map)
            binding.iconData.setImageResource(R.drawable.ic_data)
            binding.iconProfile.setImageResource(R.drawable.ic_profile)
        }

        binding.buttonMap.setOnClickListener {
            binding.iconHome.setImageResource(R.drawable.ic_home)
            binding.iconMap.setImageResource(R.drawable.ic_map_selected)
            binding.iconData.setImageResource(R.drawable.ic_data)
            binding.iconProfile.setImageResource(R.drawable.ic_profile)
        }

        binding.buttonData.setOnClickListener {
            binding.iconHome.setImageResource(R.drawable.ic_home)
            binding.iconMap.setImageResource(R.drawable.ic_map)
            binding.iconData.setImageResource(R.drawable.ic_data_selected)
            binding.iconProfile.setImageResource(R.drawable.ic_profile)
        }

        binding.buttonProfile.setOnClickListener {
            binding.iconHome.setImageResource(R.drawable.ic_home)
            binding.iconMap.setImageResource(R.drawable.ic_map)
            binding.iconData.setImageResource(R.drawable.ic_data)
            binding.iconProfile.setImageResource(R.drawable.ic_profile_selected)
        }


    }
}