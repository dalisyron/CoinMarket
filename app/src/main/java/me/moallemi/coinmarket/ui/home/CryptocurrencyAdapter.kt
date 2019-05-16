package me.moallemi.coinmarket.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.moallemi.coinmarket.R
import me.moallemi.coinmarket.data.entity.CurrencyInfoEntity
import me.moallemi.coinmarket.domain.model.CurrencyInfo

class CryptocurrencyAdapter(private var items : List<CurrencyInfo?>) : RecyclerView.Adapter<CurrencyInfoViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CurrencyInfoViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_cryptocurrency_item, p0, false)
        return CurrencyInfoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(p0: CurrencyInfoViewHolder, p1: Int) {
        p0.bind(items[p1])
    }

}