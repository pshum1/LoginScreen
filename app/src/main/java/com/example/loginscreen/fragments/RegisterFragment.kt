package com.example.loginscreen.fragments

import android.content.Context
import android.os.Bundle
import android.se.omapi.Session
import android.util.Log
import android.view.ContextMenu
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.loginscreen.R
import com.example.loginscreen.helpers.SessionManager
import com.example.loginscreen.models.User
import kotlinx.android.synthetic.main.fragment_register.view.*


class RegisterFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_register, container, false)

        init(view)

        return view
    }

    private fun init(view: View) {

        view.button_register.setOnClickListener {



            var name: String = view.edit_text_name.text.toString()
            var number: String = view.edit_text_number.text.toString()
            var email: String = view.edit_text_loginEmail.text.toString()
            var password: String = view.edit_text_loginPassword.text.toString()

            var user = User(name, number, email, password)

            if (name == "" || number == "" || email == "" || password == "") {
                Toast.makeText(context, "Enter all fields!", Toast.LENGTH_SHORT).show()
            } else {
//                Log.d("abc", name)
//                Log.d("abc", number)
//                Log.d("abc", email)
//                Log.d("abc", password)

                //SAVE TO SHAREDPREFERENCE
//                var sharedPreferences =
////                    activity!!.getSharedPreferences("myfav", Context.MODE_PRIVATE)
////                var editor = sharedPreferences.edit()
////                editor.putString("NAME", name)
////                editor.putString("NUMBER", number)
////                editor.putString("EMAIL", email)
////                editor.putString("PASSWORD", password)
////                editor.commit()

                var sessionManager = SessionManager(activity!!)
                sessionManager.register(user)


//                var loginFragment: LoginFragment =
//                    LoginFragment.newInstance(name, number, email, password)
                activity?.supportFragmentManager?.beginTransaction()
                    ?.replace(R.id.fragment_container, LoginFragment())?.commit()
            }

        }

    }

}
