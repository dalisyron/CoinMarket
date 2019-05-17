package me.moallemi.coinmarket.domain.interactor

import io.reactivex.Single
import me.moallemi.coinmarket.domain.executer.PostExecutorThread
import me.moallemi.coinmarket.domain.executer.UseCaseExecutorThread
import me.moallemi.coinmarket.domain.interactor.base.SingleUseCase
import me.moallemi.coinmarket.domain.model.CurrencyInfo
import me.moallemi.coinmarket.domain.repository.CoinMarketRepository

class GetLatestUseCase()