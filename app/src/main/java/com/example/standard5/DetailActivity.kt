package com.example.standard5

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.standard4.R
import com.example.standard4.databinding.ActivityDetailBinding
import com.example.standard5.adaptor.CardVIewModelFactory
import com.example.standard5.adaptor.CardViewModel
import com.example.standard5.extension.extraNotNull

class DetailActivity : AppCompatActivity() {
    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }
    private val cardViewModel by viewModels<CardViewModel> {
        CardVIewModelFactory()
    }

    companion object{
        const val EXTRA_CARD: String = "extra_card"
    }

    private val cardId by extraNotNull<Long>(EXTRA_CARD)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val card = cardViewModel.getCardForId(cardId)
        binding.tvDetailName.text = card.name
        binding.tvDetailNumber.text = card.number
        binding.tvDetailPrice.text = card.price
        binding.tvDetailDate.text = card.date
    }
}