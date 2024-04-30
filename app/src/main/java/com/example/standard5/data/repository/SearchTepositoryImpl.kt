package com.example.standard5.data.repository

import com.example.standard5.data.DataSource
import com.example.standard5.presentation.mapper.asBlueCardModel
import com.example.standard5.presentation.repository.SearchRepository

class SearchRepositoryImpl(private val dataSource : DataSource) : SearchRepository {
    override fun getCardList() = dataSource.getCardList().asBlueCardModel()
}