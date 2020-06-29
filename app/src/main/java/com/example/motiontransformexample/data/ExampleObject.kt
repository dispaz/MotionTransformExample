package com.example.motiontransformexample.data

import android.graphics.Bitmap
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ExampleObject(
    val id : Int,
    val name : String,
    val imageUrl : Bitmap,
    val rating : Int
) : Parcelable
{
}