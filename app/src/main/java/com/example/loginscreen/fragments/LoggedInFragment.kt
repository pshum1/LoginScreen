package com.example.loginscreen.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.loginscreen.R
import com.example.loginscreen.helpers.SessionManager
import com.example.loginscreen.models.User
import kotlinx.android.synthetic.main.fragment_logged_in.view.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"
private const val ARG_PARAM4 = "param4"

class LoggedInFragment : Fragment() {

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
        var view = inflater.inflate(R.layout.fragment_logged_in, container, false)

//        view.tv_name.text = param1
//        view.tv_number.text = param2
//        view.tv_email.text = param3

        //SHARED PREFERENCES

//        var sharedPreferences = activity!!.getSharedPreferences("myfav", Context.MODE_PRIVATE)
//        var nameSharedPreference: String? = sharedPreferences.getString("NAME", null)
//        var numberSharedPreference: String? = sharedPreferences.getString("NUMBER", null)
//        var emailSharedPreference: String? = sharedPreferences.getString("EMAIL", null)

        //var passwordSharedPreference: String? = sharedPreferences.getString("PASSWORD", null)


//        view.tv_number.text = numberSharedPreference
//        view.tv_email.text = emailSharedPreference

        init(view)
        return view
    }

    private fun init(view: View) {
        var sessionManager = SessionManager(activity!!)
        var user: User = sessionManager.getUser()

        view.tv_name.text = user.name
        view.tv_number.text = user.number
        view.tv_email.text = user.email

        view.button_logout.setOnClickListener{
            sessionManager.logout()
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, LoginFragment())?.commit()
        }
    }

    companion object {

        fun newInstance(param1: String?, param2: String?, param3: String?, param4: String?) =
            LoggedInFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                    putString(ARG_PARAM3, param3)
                    putString(ARG_PARAM4, param4)
                }
            }
    }
}