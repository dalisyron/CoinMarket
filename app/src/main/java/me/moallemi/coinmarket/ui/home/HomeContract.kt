package me.moallemi.coinmarket.ui.home

import me.moallemi.coinmarket.domain.model.CurrencyInfo

interface HomeContract {
    interface Presenter : HomeContract {
        fun onViewCreated()
        fun onDestroyView()
    }

    interface View : HomeContract {
        fun showCryptocurrencies(items: List<CurrencyInfo?>)

    }
}