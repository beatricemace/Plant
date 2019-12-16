package com.example.letsplant

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Plant(
    val id: Int = 0,
    val name: String? = null,
    val type: String? = null,
    val date: String? = null,
    val description: String? = null
) : Parcelable