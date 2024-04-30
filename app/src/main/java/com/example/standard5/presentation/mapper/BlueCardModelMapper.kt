package com.example.standard5.presentation.mapper

import com.example.standard5.data.BlueCardEntity
import com.example.standard5.presentation.model.BlueCardModel

fun List<BlueCardEntity>.asBlueCardModel(): List<BlueCardModel> {
    return map {
        BlueCardModel(
            it.userName,
            it.cardNumber,
            it.cardType,
            it.period,
            it.balance,
            it.cardManager,
            it.cardViewType
        )
    }
}