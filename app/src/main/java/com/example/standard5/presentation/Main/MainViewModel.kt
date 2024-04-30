package com.example.standard5.presentation.Main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.standard5.data.DataSource
import com.example.standard5.data.repository.SearchRepositoryImpl
import com.example.standard5.presentation.model.BlueCardModel
import com.example.standard5.presentation.repository.SearchRepository

class MainViewModel(private val searchRepository: SearchRepository) : ViewModel() {

    private val _getBlueCardModel : MutableLiveData<List<BlueCardModel>> = MutableLiveData()

    val getBlueCardModel : LiveData<List<BlueCardModel>> get() = _getBlueCardModel

    fun getBlueCardModel() {
        _getBlueCardModel.value = searchRepository.getCardList()
    }
}

class MainViewModelFactory : ViewModelProvider.Factory {
    override  fun <T : ViewModel> create(
        modleClass: Class<T>,
        extras: CreationExtras
    ): T {

        return MainViewModel(
            SearchRepositoryImpl(DataSource)
        ) as T
    }
}