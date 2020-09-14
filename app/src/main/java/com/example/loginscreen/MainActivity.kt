package com.example.loginscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.loginscreen.fragments.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("abc", "OnCreate")

        init()
    }

    private fun init() {
        Log.d("abc", "initMain")
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, LoginFragment()).commit()
    }
}