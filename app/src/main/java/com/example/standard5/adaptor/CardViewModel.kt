package com.example.standard5.adaptor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.standard5.data.CardInfo
import com.example.standard5.data.DataSource
import java.lang.IllegalArgumentException

class CardViewModel(val dataSource: DataSource) : ViewModel() {
    val cardLiveData = dataSource.getCardList()

    fun getCardForId(id:Long): CardInfo {
        cardLiveData.let{card ->
            return card.first{it.id == id}
        }
    }
}

class CardVIewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CardViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CardViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}