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


class LoginFragment : Fragment() {
    lateinit var binding : LoginFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment,container,false)


        binding.ExistBtn.setOnClickListener { view:View ->

            view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())

        }


        binding.NewLoginBtn.setOnClickListener { view:View ->

            view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())

        }
        return binding.root
    }



}