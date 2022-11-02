package com.rustyrobot.recordkeeper

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rustyrobot.recordkeeper.databinding.FragmentCyclingBinding

class CyclingFragment : Fragment() {

    private lateinit var binding: FragmentCyclingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCyclingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.containerBestSpeed.setOnClickListener {
            launchCyclingRecordScreen(binding.textViewBestSpeedHeading.text.toString())
        }
        binding.containerBiggestClimb.setOnClickListener {
            launchCyclingRecordScreen(binding.textViewBiggestClimbHeading.text.toString())
        }
        binding.containerLongestRide.setOnClickListener {
            launchCyclingRecordScreen(binding.textViewLongestRideHeading.text.toString())
        }
    }

    private fun launchCyclingRecordScreen(distance: String) {
        val intent = Intent(context, EditCyclingRecordActivity::class.java)
        intent.putExtra("Distance", distance)
        startActivity(intent)
    }

}
