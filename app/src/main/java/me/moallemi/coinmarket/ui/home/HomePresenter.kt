package me.moallemi.coinmarket.ui.home

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import me.moallemi.coinmarket.domain.repository.CoinMarketRepository
import java.lang.ref.WeakReference
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo

class HomePresenter(private val repository: CoinMarketRepository) : HomeContract.Presenter {

    lateinit var view : WeakReference<HomeContract.View>
    private var compositeDisposable = CompositeDisposable()

    override fun onViewCreated() {

        val repository = me.moallemi.coinmarket.Injector.provideCryptocurrencyRepository()

        repository.getLatest()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess {
                view.get()?.showCryptocurrencies(it)
            }
            .subscribe().addTo(compositeDisposable)
    }

    override fun onDestroyView() {
        compositeDisposable.dispose()
    }
}