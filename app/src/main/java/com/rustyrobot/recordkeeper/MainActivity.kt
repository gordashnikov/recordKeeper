package com.rustyrobot.recordkeeper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.rustyrobot.recordkeeper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_cycling -> {
                    onCyclingClicked()
                    true
                }
                R.id.nav_running -> {
                    onRunningClicked()
                    true
                }
                else -> false
            }
        }
    }

    private fun onRunningClicked() {
        supportFragmentManager.commit {
            replace(R.id.frame_content, RunningFragment())
        }

    }

    private fun onCyclingClicked() {
        supportFragmentManager.commit {
            replace(R.id.frame_content, CyclingFragment())
        }

    }


}