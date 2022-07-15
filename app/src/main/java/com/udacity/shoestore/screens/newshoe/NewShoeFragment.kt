package com.udacity.shoestore.screens.newshoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentNewShoeBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.MyViewModel


class NewShoeFragment : Fragment() {

    private val sharedViewModel: MyViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val bind = DataBindingUtil.inflate<FragmentNewShoeBinding>(inflater,R.layout.fragment_new_shoe, container, false)

        bind.shoe = Shoe("","","","","")


       bind.SaveBtn.setOnClickListener { view :View ->

            if(bind.ShoeNameEditText.text.isNotEmpty() && bind.CompanyNameEditText.text.isNotEmpty() && bind.PriceEditText.text.isNotEmpty()){

                bind.shoe?.let { sharedViewModel.addShoe(it) }
                Toast.makeText(activity,"Item is added", Toast.LENGTH_SHORT).show()
                view.findNavController().popBackStack()


            }else {

                when{
                    bind.ShoeNameEditText.text.isEmpty() -> {bind.ShoeNameEditText.error = "Fill required data"
                        bind.ShoeNameEditText.requestFocus()}
                    bind.CompanyNameEditText.text.isEmpty() -> {bind.CompanyNameEditText.error = "Fill required data"
                        bind.CompanyNameEditText.requestFocus()}
                    bind.PriceEditText.text.isEmpty() -> {bind.PriceEditText.error = "Fill required data"
                        bind.PriceEditText.requestFocus()}
                }
            }
       }


        bind.CancelBtn.setOnClickListener { view :View ->
            view.findNavController().popBackStack()
        }

        return bind.root
    }


}