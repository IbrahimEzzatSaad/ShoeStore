package com.udacity.shoestore.screens.home

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentHomeBinding
import com.udacity.shoestore.screens.instruction.InstructionFragmentDirections
import kotlinx.android.synthetic.main.item_list.view.*


class HomeFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        var bind = DataBindingUtil.inflate<FragmentHomeBinding>(inflater,R.layout.fragment_home,container,false)
        var view = inflater.inflate(R.layout.item_list, bind.linear)
        view.Name.text = "its a shoe"
        var view2 = inflater.inflate(R.layout.item_list, bind.linear)
        var view3 = inflater.inflate(R.layout.item_list, bind.linear)
        setHasOptionsMenu(true)

        // calling the action bar
        var actionBar = (activity as AppCompatActivity).supportActionBar

        // disabling the back button in action bar
        actionBar?.setDisplayHomeAsUpEnabled(false)



        return bind.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.right_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) : Boolean{

        view?.findNavController()?.navigate(HomeFragmentDirections.actionHomeFragmentToLoginFragment())

        return true
    }

}