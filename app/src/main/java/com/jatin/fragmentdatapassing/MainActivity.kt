package com.jatin.fragmentdatapassing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.jatin.fragmentdatapassing.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var navController1: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController1 = findNavController(R.id.navController)
    }
}