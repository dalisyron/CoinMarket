package me.moallemi.coinmarket.di

import dagger.Module
import dagger.Provides
import me.moallemi.coinmarket.data.datasource.CoinMarketRemoteDataSource
import me.moallemi.coinmarket.data.repository.CoinMarketRepositoryImpl
import me.moallemi.coinmarket.domain.repository.CoinMarketRepository
import me.moallemi.coinmarket.remote.api.CoinMarketService
import me.moallemi.coinmarket.remote.datasource.CoinMarketRemoteDataSourceImpl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
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
    fun providesOkHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.addInterceptor(
            object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {
                    val request = chain.request().newBuilder()
                        .addHeader("X-CMC_PRO_API_KEY", "fbd6208e-741b-41a0-813f-2b0ffb902356").build()
                    return chain.proceed(request)
                }
            }
        )
        return okHttpClient.build()
    }

    @Provides
    @Singleton
    fun providesCoinMarketServiceRetrofit(okHttpClient: OkHttpClient)
            : Retrofit {
        return Retrofit.Builder()
            .baseUrl(CoinMarketService.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient).build()
    }

    @Provides
    @Singleton
    fun providesCoinMarketService(retrofit: Retrofit) : CoinMarketService {
        return retrofit.create()
    }
}