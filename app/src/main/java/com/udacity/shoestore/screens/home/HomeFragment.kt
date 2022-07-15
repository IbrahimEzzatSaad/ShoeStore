package com.udacity.shoestore.screens.home

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentHomeBinding
import com.udacity.shoestore.databinding.ShoeitemBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*


class HomeFragment : Fragment() {

    private val sharedViewModel: MyViewModel by activityViewModels()
    private lateinit var bind : FragmentHomeBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        bind = DataBindingUtil.inflate<FragmentHomeBinding>(inflater,R.layout.fragment_home,container,false)


        (activity as AppCompatActivity).toolbar.inflateMenu(R.menu.right_menu)



        bind.floatBtn.setOnClickListener{ view :View ->

            view.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToNewShoeFragment())

        }
        setHasOptionsMenu(true)
        showList()

        return bind.root
    }


    private fun showList(){
        sharedViewModel.MyList.observe(viewLifecycleOwner, Observer { newMyList ->

            newMyList.forEach {shoe: Shoe ->

                val shoeitem = ShoeitemBinding.inflate(LayoutInflater.from(requireContext()), bind.linear, false)
                shoeitem.apply {
                    Name.text = shoe.name

                    description.text = if(shoe.description.isEmpty()){ "Made By: ${shoe.company}" } else {
                        shoe.description
                    }

                    Price.text = "${shoe.price}$"
                }

                bind.linear.addView(shoeitem.root)
            }
        })


     }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.right_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) : Boolean{
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}