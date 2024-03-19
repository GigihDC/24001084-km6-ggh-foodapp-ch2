package com.dev.foodapp.feature.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dev.foodapp.R
import com.dev.foodapp.databinding.ActivityMainBinding
import com.dev.foodapp.feature.menu.home.HomeFragment
import com.dev.foodapp.feature.menu.profile.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_menu, HomeFragment())
            .commit()

        binding.bnvMenu.setOnItemSelectedListener { item ->
            when (item.getItemId()) {
                R.id.navigation_home -> replaceFragment(HomeFragment())
                R.id.navigation_checkout -> replaceFragment(Fragment())
                R.id.navigation_history -> replaceFragment(Fragment())
                R.id.navigation_profile -> replaceFragment(ProfileFragment())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_menu, fragment)
        fragmentTransaction.commit()
    }
}