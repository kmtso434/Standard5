package com.example.standard5.data

import android.os.Parcelable
import com.example.standard5.presentation.Main.MultiViewEnum
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CardInfo(
    val id: Long,
    val name: String,
    val number: String,
    val date: String,
    val price: String,
    val cardManager: String,
    val cardViewType : MultiViewEnum
) : Parcelable