package me.moallemi.coinmarket.ui.home

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import me.moallemi.coinmarket.domain.repository.CoinMarketRepository
import java.lang.ref.WeakReference
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import me.moallemi.coinmarket.Injector
import javax.inject.Inject

class HomePresenter @Inject constructor (private val coinMarketRepository: CoinMarketRepository) : HomeContract.Presenter {

    lateinit var view : WeakReference<HomeContract.View>
    private var compositeDisposable = CompositeDisposable()

    override fun onViewCreated() {

        coinMarketRepository.getLatest()
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