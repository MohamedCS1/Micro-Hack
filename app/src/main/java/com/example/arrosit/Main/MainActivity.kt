package com.example.arrosit.Main

import android.content.pm.PackageManager
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.arrosit.Camera.CameraFragment
import com.example.arrosit.Map.MapFragment
import com.example.arrosit.Profile.ProfileFragment
import com.example.arrosit.R
import com.example.arrosit.Utils.IntentUtils
import com.example.arrosit.Utils.RequestCodes
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
            checkCameraPermission()

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


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == RequestCodes.camera)
        {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                binding.iconZones.setImageResource(R.drawable.ic_zones)
                binding.iconMap.setImageResource(R.drawable.ic_map)
                binding.iconInsights.setImageResource(R.drawable.ic_insights)
                binding.iconScan.setImageResource(R.drawable.ic_camera_selected)
                binding.iconProfile.setImageResource(R.drawable.ic_profile)
                setFragment(CameraFragment())
                return
            }
            else if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_DENIED)
            {
                IntentUtils(this).intentToSettings()
            }

        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, arrayOf(android.Manifest.permission.CAMERA).toString()) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), RequestCodes.camera)
        }
    }
}