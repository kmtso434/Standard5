package com.example.standard5.adaptor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.standard4.databinding.CardItem1Binding
import com.example.standard4.databinding.CardItem2Binding
import com.example.standard4.databinding.CardItem3Binding
import com.example.standard5.data.CardInfo
import java.lang.RuntimeException

class CardAdapter(private val cardList: List<CardInfo>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    interface ItemClick{
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when(viewType){
            0 -> {
                val binding = CardItem1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                Holder(binding)
            }
            1 -> {
                val binding = CardItem2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                Holder1(binding)
            }
            2-> {
                val binding = CardItem3Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                Holder2(binding)
            }

            else -> throw RuntimeException("error")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            itemClick?.onClick(it, position)
        }

        val currentItem = cardList[position]
        when(holder.itemViewType) {
            0 -> {
                val holder0 = holder as Holder
                holder0.bind(currentItem)
            }
            1 -> {
                val holder1 = holder as Holder1
                holder1.bind(currentItem)
            }
            2 -> {
                val holder2 = holder as Holder2
                holder2.bind(currentItem)
            }

            else -> throw RuntimeException("error")
        }
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position % 3
    }

    inner class Holder(private val binding: CardItem1Binding) : RecyclerView.ViewHolder(binding.root){
        fun bind(card: CardInfo){
            binding.apply{
                binding.tvName.text = card.name
                binding.tvNumber.text = card.number
                binding.tvPrice.text = card.price
                binding.tvDate.text = card.date
            }
        }
    }

    inner class Holder1(private val binding: CardItem2Binding) : RecyclerView.ViewHolder(binding.root){
        fun bind(card: CardInfo){
            binding.apply{
                binding.tvName.text = card.name
                binding.tvNumber.text = card.number
                binding.tvPrice.text = card.price
                binding.tvDate.text = card.date
            }
        }
    }

    inner class Holder2(private val binding: CardItem3Binding) : RecyclerView.ViewHolder(binding.root){
        fun bind(card: CardInfo){
            binding.apply{
                binding.tvName.text = card.name
                binding.tvNumber.text = card.number
                binding.tvPrice.text = card.price
                binding.tvDate.text = card.date
            }
        }
    }
}

