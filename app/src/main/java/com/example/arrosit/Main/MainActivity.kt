package com.example.arrosit.Main

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.arrosit.Map.MapFragment
import com.example.arrosit.Profile.ProfileFragment
import com.example.arrosit.R
import com.example.arrosit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonZones.setOnClickListener {
            binding.iconZones.setImageResource(R.drawable.ic_zones_selected)
            binding.iconMap.setImageResource(R.drawable.ic_map)
            binding.iconInsights.setImageResource(R.drawable.ic_insights)
            binding.iconScan.setImageResource(R.drawable.ic_camera)
            binding.iconProfile.setImageResource(R.drawable.ic_profile)
        }

        binding.buttonMap.setOnClickListener {
            binding.iconZones.setImageResource(R.drawable.ic_zones)
            binding.iconMap.setImageResource(R.drawable.ic_map_selected)
            binding.iconInsights.setImageResource(R.drawable.ic_insights)
            binding.iconScan.setImageResource(R.drawable.ic_camera)
            binding.iconProfile.setImageResource(R.drawable.ic_profile)
            setFragment(MapFragment())
        }

        binding.buttonInsights.setOnClickListener {
            binding.iconZones.setImageResource(R.drawable.ic_zones)
            binding.iconMap.setImageResource(R.drawable.ic_map)
            binding.iconInsights.setImageResource(R.drawable.ic_insights_selected)
            binding.iconScan.setImageResource(R.drawable.ic_camera)
            binding.iconProfile.setImageResource(R.drawable.ic_profile)
        }

        binding.buttonScan.setOnClickListener {
            binding.iconZones.setImageResource(R.drawable.ic_zones)
            binding.iconMap.setImageResource(R.drawable.ic_map)
            binding.iconInsights.setImageResource(R.drawable.ic_insights)
            binding.iconScan.setImageResource(R.drawable.ic_camera_selected)
            binding.iconProfile.setImageResource(R.drawable.ic_profile)
        }

        binding.buttonProfile.setOnClickListener {
            binding.iconZones.setImageResource(R.drawable.ic_zones)
            binding.iconMap.setImageResource(R.drawable.ic_map)
            binding.iconInsights.setImageResource(R.drawable.ic_insights)
            binding.iconScan.setImageResource(R.drawable.ic_camera)
            binding.iconProfile.setImageResource(R.drawable.ic_profile_selected)
            setFragment(ProfileFragment())

        }


    }

    private fun setFragment(fragment: Fragment) {
        val fr= supportFragmentManager.beginTransaction()
        fr.replace(R.id.fragmentContainer ,fragment)
        fr.commit()
    }
}