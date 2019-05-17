package me.moallemi.coinmarket.ui

import android.app.Application
import dagger.Component
import me.moallemi.coinmarket.di.AppComponent
import me.moallemi.coinmarket.di.AppModule
import me.moallemi.coinmarket.di.DaggerAppComponent

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    companion object {
        lateinit var component : AppComponent
    }
}