package com.example.loginscreen.helpers

import android.content.Context
import android.util.Log
import com.example.loginscreen.models.User

class SessionManager (var mContext: Context){

    private val FILE_NAME = "my_pref"
    private val KEY_NAME = "name"
    private val KEY_NUMBER = "number"
    private val KEY_EMAIL = "email"
    private val KEY_PASSWORD = "password"
    private val KEY_IS_LOGGED_IN = "isloggedin"

    var sharePreferences = mContext.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    var editor = sharePreferences.edit()

    companion object{

    }

    fun register(user: User) {
        editor.putString(KEY_NAME, user.name)
        editor.putString(KEY_NUMBER, user.number)
        editor.putString(KEY_EMAIL, user.email)
        editor.putString(KEY_PASSWORD, user.password)
        editor.putBoolean(KEY_IS_LOGGED_IN, true)
        editor.commit()
    }

    fun login(user: User): Boolean {

        var saveEmail = sharePreferences.getString(KEY_EMAIL, null)
        var savePassword = sharePreferences.getString(KEY_PASSWORD, null)

        return (saveEmail == user.email && savePassword == user.password)
    }

    fun isLoggedIn(): Boolean{
        return sharePreferences.getBoolean(KEY_IS_LOGGED_IN, false)
    }

    fun getUserName(): String?{
        return sharePreferences.getString(KEY_NAME, null)
    }

    fun getUser(): User{
        var name = sharePreferences.getString(KEY_NAME, null)
        var number = sharePreferences.getString(KEY_NUMBER, null)
        var email = sharePreferences.getString(KEY_EMAIL, null)
        return User(name, number, email)

    }

    fun logout(){
        //editor.remove(KEY_NAME) deletes a key
        editor.clear()
        editor.commit()
    }


}