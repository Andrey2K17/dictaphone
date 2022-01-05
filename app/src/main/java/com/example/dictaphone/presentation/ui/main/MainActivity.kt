package com.example.dictaphone.presentation.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.dictaphone.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bnvMain)
        val navController =
            (supportFragmentManager.findFragmentById(R.id.nav_host_container) as NavHostFragment).navController
        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }