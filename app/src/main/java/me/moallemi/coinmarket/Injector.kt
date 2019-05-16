package me.moallemi.coinmarket

import me.moallemi.coinmarket.data.repository.CoinMarketRepositoryImpl
import me.moallemi.coinmarket.remote.api.CoinMarketService
import me.moallemi.coinmarket.remote.datasource.CoinMarketRemoteDataSourceImpl


object Injector {
    fun provideCryptocurrencyRepository() : CoinMarketRepositoryImpl{
        return CoinMarketRepositoryImpl(CoinMarketRemoteDataSourceImpl(CoinMarketService.create()))
    }
}