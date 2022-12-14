package com.example.colorpicker

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class SubjectColor (
    val subject: String,
    val color: Int
        ) : Parcelable