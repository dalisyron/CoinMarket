package me.moallemi.coinmarket.remote.datasource

import io.reactivex.Single
import me.moallemi.coinmarket.data.datasource.CoinMarketRemoteDataSource
import me.moallemi.coinmarket.data.entity.CurrencyInfoEntity
import me.moallemi.coinmarket.remote.api.CoinMarketService
import me.moallemi.coinmarket.remote.dto.toCurrencyInfoEntityList
import javax.inject.Inject

class CoinMarketRemoteDataSourceImpl @Inject constructor(private val coinMarketService: CoinMarketService) :
    CoinMarketRemoteDataSource {

    override fun getLatest(): Single<List<CurrencyInfoEntity>> {
        return coinMarketService.getLatest().map { listingsDto ->
            listingsDto.toCurrencyInfoEntityList()
        }
    }
}