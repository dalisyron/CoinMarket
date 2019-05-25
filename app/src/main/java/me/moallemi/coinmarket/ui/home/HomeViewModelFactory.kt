package me.moallemi.coinmarket.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.moallemi.coinmarket.data.repository.CoinMarketRepositoryImpl
import me.moallemi.coinmarket.domain.repository.CoinMarketRepository
import javax.inject.Inject

class HomeViewModelFactory(private val coinMarketRepository: CoinMarketRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(coinMarketRepository) as T
    }

}