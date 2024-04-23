package com.example.standard5.data

class DataSource {
    companion object{
        private var INSTANCE: DataSource? = null

        fun getData(): DataSource {
            return synchronized(DataSource::class) {
                val newInstance =
                    INSTANCE ?: DataSource()
                INSTANCE = newInstance
                newInstance
            }
        }
    }

    fun getCardList(): List<CardInfo>{
        return cardList()
    }


}