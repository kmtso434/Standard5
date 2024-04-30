package com.example.standard5.presentation.Main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.standard4.databinding.ItemBlueCardBinding
import com.example.standard4.databinding.ItemLightBlueCardBinding
import com.example.standard4.databinding.ItemOrangeCardBinding
import com.example.standard4.databinding.UnknowItemBinding
import com.example.standard5.presentation.model.BlueCardModel

//클릭 이벤트 처리 람다함수 파라메터로 사용
class MultiCardAdapter(private val onClick: (BlueCardModel) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var cardList = listOf<BlueCardModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val MultiViewType = MultiViewEnum.entries.find { it.viewType == viewType }
        return when (MultiViewType) {
            MultiViewEnum.BLUE -> {
                val binding =
                    ItemBlueCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                BlueTypeViewHolder(binding)
            }

            MultiViewEnum.LIGHTBLUE -> {
                val binding =
                    ItemLightBlueCardBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                LightBlueTypeViewHolder(binding)
            }

            MultiViewEnum.ORANGE -> {
                val binding =
                    ItemOrangeCardBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                OrangeTypeViewHolder(binding)
            }

            else -> {
                val binding =
                    UnknowItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                UnknownViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = cardList[position]
        when(holder) {
            is BlueTypeViewHolder -> {
                val blueHolder = holder as BlueTypeViewHolder
                blueHolder.bind(currentItem)

                holder.itemView.setOnClickListener{
                    onClick(currentItem)
                }
            }
            is LightBlueTypeViewHolder -> {
                val blueHolder = holder as LightBlueTypeViewHolder
                blueHolder.bind(currentItem)

                holder.itemView.setOnClickListener{
                    onClick(currentItem)
                }
            }
            is OrangeTypeViewHolder -> {
                val blueHolder = holder as OrangeTypeViewHolder
                blueHolder.bind(currentItem)

                holder.itemView.setOnClickListener{
                    onClick(currentItem)
                }
            }
        }
    }


    override fun getItemViewType(position: Int): Int {
        return cardList[position].cardViewType.viewType
    }

    class BlueTypeViewHolder (private val binding: ItemBlueCardBinding) :
        RecyclerView.ViewHolder(binding.root){
            fun bind(card: BlueCardModel){
                binding.apply{
                    tvUserName.text = card.userName
                    tvCardNum.text = card.cardNumber
                    tvCardType.text = card.period
                    tvBalance.text = card.balance.toString()
                    tvCardManager.text = card.cardManager
                }
            }
        }

    class LightBlueTypeViewHolder (private val binding: ItemLightBlueCardBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind(card: BlueCardModel){
            binding.apply{
                tvUserName.text = card.userName
                tvCardNum.text = card.cardNumber
                tvCardType.text = card.period
                tvBalance.text = card.balance.toString()
                tvCardManager.text = card.cardManager
            }
        }
    }


    class OrangeTypeViewHolder (private val binding: ItemOrangeCardBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(card: BlueCardModel){
            binding.apply{
                tvUserName.text = card.userName
                tvCardNum.text = card.cardNumber
                tvCardType.text = card.period
                tvBalance.text = card.balance.toString()
                tvCardManager.text = card.cardManager
            }
        }
    }

    class UnknownViewHolder(
        binding: UnknowItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind() = Unit
    }

}







