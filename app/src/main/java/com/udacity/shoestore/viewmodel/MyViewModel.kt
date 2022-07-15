package com.udacity.shoestore.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MyViewModel : ViewModel() {

    private var _MyList: MutableLiveData<List<Shoe>> = MutableLiveData(listOf())
    val MyList : LiveData<List<Shoe>>
        get() = _MyList




    init {
        addShoe(Shoe("Textile Leather-Accent","26.9","150","Salerno","Brand: Salerno " + " Type: Fashion Sneakers " + "Material: Mesh " + "Color: Navy " ,listOf("https://m.media-amazon.com/images/I/61qKsYRkPRL._AC_SY395_.jpg","null")))
        addShoe(Shoe("Womens Side Stripe Contrast","28.9","150","Generic","Brand: Generic " + " Type: Fashion Sneakers " + "Material: Mesh " + "Color: Navy ",listOf("https://m.media-amazon.com/images/I/41PUbxauc8L._AC_.jpg","null")))

        /* For more items
        addShoe(Shoe("Cochi Women's Athletic","22.9","150","Salerno","Brand: Salerno " + " Type: Fashion Sneakers " + "Material: Mesh " + "Color: Navy " ,listOf("https://m.media-amazon.com/images/I/61f8XNUKKvL._AC_SX395_.jpg","null")))
        addShoe(Shoe("Reebok Mens Energylux","24.9","150","Salerno","Brand: Salerno " + " Type: Fashion Sneakers " + "Material: Mesh " + "Color: Navy " ,listOf("https://m.media-amazon.com/images/I/71xUHR1JpdL._AC_SX695_.jpg","null")))
        addShoe(Shoe("Salerno Womens Side Stripe","23.9","150","Salerno","Brand: Salerno " + " Type: Fashion Sneakers " + "Material: Mesh " + "Color: Navy " ,listOf("https://m.media-amazon.com/images/I/61Z1hTVYC5L._AC_SX395_.jpg","null")))
         */
    }

    fun addShoe(NewShoe: Shoe) {
        _MyList.value = MyList.value?.plus(NewShoe) ?: listOf(NewShoe)
    }



}