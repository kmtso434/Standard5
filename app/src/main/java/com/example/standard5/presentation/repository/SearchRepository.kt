package com.example.standard5.presentation.repository

import com.example.standard5.presentation.model.BlueCardModel

interface SearchRepository {
    fun getCardList() : List<BlueCardModel>
}