package me.moallemi.coinmarket.remote.api

import io.reactivex.Single
import me.moallemi.coinmarket.remote.dto.ListingsDto
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface CoinMarketService {
    @GET("/v1/cryptocurrency/listings/latest")
    fun getLatest(): Single<ListingsDto>

    companion object {
        const val BASE_URL = "https://pro-api.coinmarketcap.com"

        fun create(): CoinMarketService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(
                    RxJava2CallAdapterFactory.create()
                ).addConverterFactory(
                    GsonConverterFactory.create()
                ).baseUrl(BASE_URL)
                .build()
            return retrofit.create(CoinMarketService::class.java)
        }
    }
}