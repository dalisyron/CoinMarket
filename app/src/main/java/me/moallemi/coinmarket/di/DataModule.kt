package me.moallemi.coinmarket.di

import dagger.Module
import dagger.Provides
import me.moallemi.coinmarket.data.datasource.CoinMarketRemoteDataSource
import me.moallemi.coinmarket.data.repository.CoinMarketRepositoryImpl
import me.moallemi.coinmarket.domain.repository.CoinMarketRepository
import me.moallemi.coinmarket.remote.api.CoinMarketService
import me.moallemi.coinmarket.remote.datasource.CoinMarketRemoteDataSourceImpl
import javax.inject.Singleton

@Module
class DataModule {
    @Provides
    @Singleton
    fun providesCoinMarketRepository(coinMarketRepository: CoinMarketRepositoryImpl): CoinMarketRepository {
        return coinMarketRepository
    }

    @Provides
    @Singleton
    fun providesCoinMarketRemoteDataSource(coinMarketRemoteDataSource: CoinMarketRemoteDataSourceImpl)
            : CoinMarketRemoteDataSource {
        return coinMarketRemoteDataSource
    }

    @Provides
    @Singleton
    fun providesCoinMarketService()
            : CoinMarketService {
        return CoinMarketService.create()
    }
}