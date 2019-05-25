package me.moallemi.coinmarket.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import me.moallemi.coinmarket.R
import me.moallemi.coinmarket.domain.model.CurrencyInfo
import me.moallemi.coinmarket.ui.MyApp
import java.lang.ref.WeakReference
import java.util.*
import javax.inject.Inject

class HomeFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    @Inject
    lateinit var homeViewModelFactory : HomeViewModelFactory

    @Inject
    lateinit var homeViewModel : HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MyApp.component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(view.context)
            addItemDecoration(
                DividerItemDecoration(
                    view.context,
                    DividerItemDecoration.VERTICAL
                )
            )
        }
        homeViewModel.currencies.observe(this@HomeFragment, Observer {
            currencyInfoList -> showCryptocurrencies(currencyInfoList)

        })
        homeViewModel.onViewCreated()
    }

    fun showCryptocurrencies(items: List<CurrencyInfo?>) {
        recyclerView.adapter = CryptocurrencyAdapter(items)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        homeViewModel.onDestroy()
    }

}
