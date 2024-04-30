package com.example.standard5.presentation.model

import android.os.Parcelable
import com.example.standard5.presentation.Main.MultiViewEnum
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BlueCardModel(
    val userName: String,
    val cardNumber: String,
    val cardType: String,
    val period: String,
    val balance: Double,
    val cardManager: String,
    val cardViewType : MultiViewEnum
) : Parcelable