package com.example.letsplant

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Plant(
    val name: String,
    val type: String,
    val date: String,
    val description: String
) : Parcelable