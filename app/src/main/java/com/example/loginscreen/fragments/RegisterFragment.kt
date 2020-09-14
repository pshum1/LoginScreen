package com.example.loginscreen.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.loginscreen.R
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
            var name: String? = view.edit_text_name.text.toString()
            var number: String? = view.edit_text_number.text.toString()
            var email: String? = view.edit_text_loginEmail.text.toString()
            var password: String? = view.edit_text_loginPassword.text.toString()

            Log.d("abc", name)
            Log.d("abc", number)
            Log.d("abc", email)
            Log.d("abc", password)


            var loginFragment: LoginFragment =
                LoginFragment.newInstance(name, number, email, password)
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.fragment_container, loginFragment)?.commit()

        }

    }

}
