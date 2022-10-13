package com.example.colorpicker

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class ColorCode (
    val code: String,
    val color: Int
        ) : Parcelable