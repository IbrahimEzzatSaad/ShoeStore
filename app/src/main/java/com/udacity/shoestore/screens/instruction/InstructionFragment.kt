package com.udacity.shoestore.screens.instruction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionBinding


class InstructionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var binding = DataBindingUtil.inflate<FragmentInstructionBinding>(inflater,R.layout.fragment_instruction,container,false)

        binding.button.setOnClickListener { view: View ->


            view.findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToHomeFragment())

        }
        return binding.root
    }


}