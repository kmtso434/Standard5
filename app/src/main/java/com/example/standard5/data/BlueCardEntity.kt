package com.example.standard5.data

import com.example.standard5.presentation.Main.MultiViewEnum

data class BlueCardEntity(
    val userName: String,
    val cardNumber: String,
    val cardType: String,
    val period: String,
    val balance: Double,
    val cardManager: String,
    val cardViewType : MultiViewEnum
)

