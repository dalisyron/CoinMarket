package me.moallemi.coinmarket.di

import dagger.Component
import me.moallemi.coinmarket.MainActivity
import me.moallemi.coinmarket.ui.home.HomeFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, DataModule::class, HomeModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(homeFragment: HomeFragment)
}