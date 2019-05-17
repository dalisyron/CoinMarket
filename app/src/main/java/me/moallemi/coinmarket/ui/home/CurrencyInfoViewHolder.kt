package me.moallemi.coinmarket.ui.home

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.moallemi.coinmarket.R
import me.moallemi.coinmarket.data.entity.toFixedDecimal
import me.moallemi.coinmarket.domain.model.CurrencyInfo

class CurrencyInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name: TextView = itemView.findViewById(R.id.name)
    val price: TextView = itemView.findViewById(R.id.price)
    val percentChange24: TextView = itemView.findViewById(R.id.percentChange24)
    val rank: TextView = itemView.findViewById(R.id.rank)

    fun bind(currencyInfo: CurrencyInfo?) {
        name.text = currencyInfo?.name
        price.text = currencyInfo?.quote?.uSD?.price.toFixedDecimal(2).toString()
        percentChange24.text = currencyInfo?.quote?.uSD?.percentChange24h.toFixedDecimal(2).toString()
        rank.text = currencyInfo?.cmcRank.toString()
    }
}

