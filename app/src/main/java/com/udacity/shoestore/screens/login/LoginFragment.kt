package com.udacity.shoestore.screens.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding


class LoginFragment : Fragment(), View.OnClickListener {
    lateinit var binding : LoginFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment,container,false)


        binding.ExistBtn.setOnClickListener { view:View ->

            view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())

        }

        return binding.root
    }

    override fun onClick(p0: View?) {
        if (p0?.id == binding.NewLoginBtn.id || p0?.id == binding.ExistBtn.id) {
            findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
            Log.i("ELLO", "I been clicked")

        }
    }


}