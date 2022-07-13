package com.udacity.shoestore.screens.home

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentHomeBinding
import com.udacity.shoestore.viewmodel.MyViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.shoeitem.view.*
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.udacity.shoestore.databinding.ShoeitemBinding
import com.udacity.shoestore.models.Shoe


class HomeFragment : Fragment() {

    private val sharedViewModel: MyViewModel by activityViewModels()

    private lateinit var bind : FragmentHomeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        bind = DataBindingUtil.inflate<FragmentHomeBinding>(inflater,R.layout.fragment_home,container,false)


        val view = inflater.inflate(R.layout.shoeitem, bind.linear)
        view.Name.text = "its a shoe"
        var view2 = inflater.inflate(R.layout.shoeitem, bind.linear)
        var view3 = inflater.inflate(R.layout.shoeitem, bind.linear)
        setHasOptionsMenu(true)

        // calling the action bar
        var actionBar = (activity as AppCompatActivity).supportActionBar

        // disabling the back button in action bar
        actionBar?.setDisplayHomeAsUpEnabled(false)

        showList()


        bind.floatBtn.setOnClickListener{ view :View ->


        }

        return bind.root
    }


    private fun showList(){
        sharedViewModel.MyList.observe(viewLifecycleOwner, Observer { newMyList ->

            newMyList.forEach {shoe: Shoe ->

                val shoeitem = ShoeitemBinding.inflate(LayoutInflater.from(requireContext()), bind.linear, false)
                shoeitem.apply {
                    Name.text = shoe.name
                    description.text = shoe.description
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

        view?.findNavController()?.navigate(HomeFragmentDirections.actionHomeFragmentToLoginFragment())

        return true
    }

}