package me.moallemi.coinmarket.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import me.moallemi.coinmarket.domain.repository.CoinMarketRepository
import me.moallemi.coinmarket.ui.home.HomeViewModel
import me.moallemi.coinmarket.ui.home.HomeViewModelFactory

@Module
class HomeModule {

    @Provides
    fun providesHomeViewModelFactory(coinMarketRepository: CoinMarketRepository) : HomeViewModelFactory {
        return HomeViewModelFactory(coinMarketRepository)
    }

    @Provides
    fun providesHomeViewModel(coinMarketRepository: CoinMarketRepository) : HomeViewModel {
        return HomeViewModel(coinMarketRepository)
    }
}