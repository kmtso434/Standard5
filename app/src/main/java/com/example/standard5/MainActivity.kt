package com.example.standard5

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.standard4.R
import com.example.standard4.databinding.ActivityMainBinding
import com.example.standard5.adaptor.CardAdapter
import com.example.standard5.adaptor.CardVIewModelFactory
import com.example.standard5.adaptor.CardViewModel
import com.example.standard5.adaptor.ItemSpace
import com.example.standard5.data.cardList
import com.example.standard5.extension.lauchActivity

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val cardViewModel by viewModels<CardViewModel> {
        CardVIewModelFactory()
    }
    private val cardAdapter by lazy { CardAdapter(cardViewModel.cardLiveData) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.cardView.adapter = cardAdapter
        binding.cardView.layoutManager = LinearLayoutManager(this)
        binding.cardView.addItemDecoration(ItemSpace(this, 15))

        cardAdapter.itemClick = object : CardAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                lauchActivity<DetailActivity>(
                    DetailActivity.EXTRA_CARD to cardList()[position].id
                )


            }
        }
    }
}