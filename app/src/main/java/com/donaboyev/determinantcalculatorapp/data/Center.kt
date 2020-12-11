package com.donaboyev.determinantcalculatorapp.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Center(
    val posX: Int?,
    val posY: Int?
) : Parcelable
