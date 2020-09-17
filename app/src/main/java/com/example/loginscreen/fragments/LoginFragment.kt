package com.example.loginscreen.fragments

import android.content.Context
import android.os.Bundle
import android.se.omapi.Session
import android.text.InputType
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.loginscreen.R
import com.example.loginscreen.helpers.SessionManager
import com.example.loginscreen.models.User
import kotlinx.android.synthetic.main.fragment_login.view.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"
private const val ARG_PARAM4 = "param4"

class LoginFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var param3: String? = null
    private var param4: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            param3 = it.getString(ARG_PARAM3)
            param4 = it.getString(ARG_PARAM4)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_login, container, false)
        Log.d("abc", "onCreateView")


        init(view)



        return view
    }

    private fun init(view: View) {
        Log.d("abc", "initFrag")
        var flag = false


        view.button_signIn.setOnClickListener {
            var email: String = view.et_loginEmail.text.toString()
            var password: String = view.et_loginPassword.text.toString()

            var user = User(email = email, password = password)

//            var emailSaved: String? = param3
//            var passSaved: String? = param4

            //SHARED PREFERENCE
//            var sharedPreferences = activity!!.getSharedPreferences("myfav", Context.MODE_PRIVATE)
//            var emailSharedPreference: String? = sharedPreferences.getString("EMAIL", null)
//            var passwordSharedPreference: String? = sharedPreferences.getString("PASSWORD", null)

//            if (email == ""|| password == "") {
//                Toast.makeText(context, "Enter email/password!", Toast.LENGTH_LONG).show()
//            } else if(email == emailSharedPreference && password == passwordSharedPreference){
//                var loggedInFragment: LoggedInFragment = LoggedInFragment.newInstance(param1, param2, param3, param4)
//                activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, loggedInFragment)?.commit()
//            } else {
//                Toast.makeText(context, "Incorrect email/password!", Toast.LENGTH_LONG).show()
//            }

            var sessionManager = SessionManager(activity!!)
            if(sessionManager.login(user)){
                activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, LoggedInFragment())?.commit()
            } else {
                Toast.makeText(context, "Incorrect email/password!", Toast.LENGTH_LONG).show()
            }


        }

        view.button_register_login_screen.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, RegisterFragment())?.commit()
        }

        view.button_show_password.setOnClickListener{
            if(!flag){
                view.et_loginPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                flag = true
            } else {
                view.et_loginPassword.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
                flag = false
            }
            Log.d("flag", flag.toString())
        }




    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String?, param2: String?, param3: String?, param4: String?) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                    putString(ARG_PARAM3, param3)
                    putString(ARG_PARAM4, param4)
                }
            }
    }
}