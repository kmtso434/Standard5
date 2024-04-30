package com.example.standard5.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.standard4.databinding.ActivityDetailBinding
import com.example.standard5.extension.getParcelableExtra
import com.example.standard5.presentation.model.BlueCardModel

class DetailActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    companion object{
        const val EXTRA_CARD: String = "extra_card"
    }

    private val blueCardModel by getParcelableExtra<BlueCardModel>(EXTRA_CARD)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        initView()
    }

    private fun initView(){
        binding.tvDetailName.text = blueCardModel?.userName
        binding.tvDetailNumber.text = blueCardModel?.cardNumber
        binding.detailPeiod.text = blueCardModel?.period
        binding.detailViewType.text = blueCardModel?.cardViewType?.name
    }
}