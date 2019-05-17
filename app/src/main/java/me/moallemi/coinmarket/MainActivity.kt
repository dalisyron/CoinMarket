package me.moallemi.coinmarket

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.moallemi.coinmarket.ui.MyApp
import me.moallemi.coinmarket.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MyApp.component.inject(this)
        setContentView(R.layout.activity_main)
        Application.context = this
        /*
        var cryptocurrencyRepository = Injector.provideCryptocurrencyRepository()
        cryptocurrencyRepository.getLatestCryptocurrencies {
            it.forEach {
                println(it)
            }
        }
        */
        supportFragmentManager.beginTransaction()
            .replace(R.id.content_frame, HomeFragment())
            .commit()
    }
}
