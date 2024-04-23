package com.example.standard5.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardInfo(val id: Long, val name: String, val number: String, val date: String, val price: String): Parcelable