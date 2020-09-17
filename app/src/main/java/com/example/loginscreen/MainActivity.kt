package com.example.loginscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.se.omapi.Session
import android.util.Log
import com.example.loginscreen.fragments.LoggedInFragment
import com.example.loginscreen.fragments.LoginFragment
import com.example.loginscreen.helpers.SessionManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("abc", "OnCreate")

        init()
    }

    private fun init() {
        var sessionManager = SessionManager(this)
        Log.d("abc", "initMain")
        if(sessionManager.isLoggedIn()){
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, LoggedInFragment()).commit()
        } else {
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, LoginFragment()).commit()
        }

    }
}