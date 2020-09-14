package com.example.loginscreen.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.loginscreen.R
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

        var name: String = param1?.toString() ?: "emptyname"
        var number: String = param2?.toString() ?: "emptynumber"
        var email: String = param3?.toString() ?: "emptyemail"
        var pass: String = param4?.toString() ?: "emptypass"

        Log.d("view", name)
        Log.d("view", number)
        Log.d("view", email)
        Log.d("view", pass)

        init(view)



        return view
    }

    private fun init(view: View) {
        Log.d("abc", "initFrag")


        view.button_signIn.setOnClickListener {
            var email: String? = view.et_loginEmail.text.toString()
            var password: String? = view.et_loginPassword.text.toString()

            var emailSaved: String? = param3
            var passSaved: String? = param4

            if (email == null || password == null) {
                Toast.makeText(context, "Enter email/password!", Toast.LENGTH_LONG).show()
            } else if(email == emailSaved && password == passSaved){
                var loggedInFragment: LoggedInFragment = LoggedInFragment.newInstance(param1, param2, param3, param4)
                activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, loggedInFragment)?.commit()
            } else {
                Toast.makeText(context, "Incorrect email/password!", Toast.LENGTH_LONG).show()
            }
        }

        view.button_register_login_screen.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, RegisterFragment())?.commit()
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