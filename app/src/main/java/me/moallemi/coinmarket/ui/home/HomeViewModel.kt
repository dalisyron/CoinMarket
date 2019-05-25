package me.moallemi.coinmarket.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import me.moallemi.coinmarket.domain.model.CurrencyInfo
import me.moallemi.coinmarket.domain.repository.CoinMarketRepository
import java.util.*

class HomeViewModel(private val coinMarketRepository: CoinMarketRepository) : ViewModel() {

    private val _currencies = MutableLiveData<List<CurrencyInfo>>()
    var currencies : LiveData<List<CurrencyInfo>> = _currencies

    val compositeDisposable = CompositeDisposable()

    fun onViewCreated() {
        coinMarketRepository.getLatest()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { resultCurrencies : List<CurrencyInfo> ->
                _currencies.postValue(resultCurrencies)
            }.addTo(compositeDisposable)
    }

    fun onDestroy() {
        compositeDisposable.dispose()
    }
}