package me.moallemi.coinmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.moallemi.coinmarket.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
