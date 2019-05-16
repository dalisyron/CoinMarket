package me.moallemi.coinmarket.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import me.moallemi.coinmarket.Injector
import me.moallemi.coinmarket.R
import me.moallemi.coinmarket.data.entity.CurrencyInfoEntity
import me.moallemi.coinmarket.domain.model.CurrencyInfo

import java.lang.ref.WeakReference

class HomeFragment : Fragment(), HomeContract.View {
    private lateinit var recyclerView : RecyclerView

    private val presenter : HomeContract.Presenter by lazy {
        HomePresenter(Injector.provideCryptocurrencyRepository()).apply {
            this.view = WeakReference(this@HomeFragment)
        }
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
        presenter.onViewCreated()
    }

    override fun showCryptocurrencies(items : List<CurrencyInfo?>) {
        recyclerView.adapter = CryptocurrencyAdapter(items)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.onDestroyView()
    }

}
