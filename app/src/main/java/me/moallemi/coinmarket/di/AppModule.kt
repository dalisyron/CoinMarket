package me.moallemi.coinmarket.di

import android.content.Context
import dagger.Module
import dagger.Provides
import me.moallemi.coinmarket.ui.MyApp
import javax.inject.Singleton

@Module
class AppModule(val myApp: MyApp) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return myApp.applicationContext
    }

}