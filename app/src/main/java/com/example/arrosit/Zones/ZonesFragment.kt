package com.example.arrosit.Zones

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.arrosit.R
import com.example.arrosit.ZoneDetails.ZoneDetailsActivity
import com.example.arrosit.databinding.FragmentZonesBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ZonesFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentZonesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentZonesBinding.inflate(layoutInflater)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.buttonZoneA.setOnClickListener {
            val intent = Intent(requireContext() ,ZoneDetailsActivity::class.java)
            intent.putExtra("zoneName" ,"Zone A")
            intent.putExtra("zoneSize" ,"130m2")
            startActivity(intent)
        }

        binding.buttonZoneB.setOnClickListener {
            val intent = Intent(requireContext() ,ZoneDetailsActivity::class.java)
            intent.putExtra("zoneName" ,"Zone B")
            intent.putExtra("zoneSize" ,"90m2")
            startActivity(intent)
        }

        binding.buttonZoneC.setOnClickListener {
            val intent = Intent(requireContext() ,ZoneDetailsActivity::class.java)
            intent.putExtra("zoneName" ,"Zone C")
            intent.putExtra("zoneSize" ,"170m2")
            startActivity(intent)
        }

        binding.buttonZoneD.setOnClickListener {
            val intent = Intent(requireContext() ,ZoneDetailsActivity::class.java)
            intent.putExtra("zoneName" ,"Zone D")
            intent.putExtra("zoneSize" ,"185m2")
            startActivity(intent)
        }

        binding.buttonZoneE.setOnClickListener {
            val intent = Intent(requireContext() ,ZoneDetailsActivity::class.java)
            intent.putExtra("zoneName" ,"Zone E")
            intent.putExtra("zoneSize" ,"135m2")
            startActivity(intent)
        }


        binding.buttonZoneF.setOnClickListener {
            val intent = Intent(requireContext() ,ZoneDetailsActivity::class.java)
            intent.putExtra("zoneName" ,"Zone F")
            intent.putExtra("zoneSize" ,"200m2")
            startActivity(intent)
        }
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ZonesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}