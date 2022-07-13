package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(var name: String, var size: Double, val price:Int , var company: String, var description: String, val images: List<String> = mutableListOf()) : Parcelable