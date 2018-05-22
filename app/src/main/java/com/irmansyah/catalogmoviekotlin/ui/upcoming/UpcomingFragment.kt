package com.irmansyah.catalogmoviekotlin.ui.upcoming


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.irmansyah.catalogmoviekotlin.BR

import com.irmansyah.catalogmoviekotlin.R
import com.irmansyah.catalogmoviekotlin.databinding.FragmentUpcomingBinding
import com.irmansyah.catalogmoviekotlin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_upcoming.*
import javax.inject.Inject

class UpcomingFragment : BaseFragment<FragmentUpcomingBinding, UpcomingViewModel>(), UpcomingNavigator {

    companion object {
        var TAG = "UpcomingFragment"

        fun newInstance(): UpcomingFragment = UpcomingFragment()
    }

    internal lateinit var binding: FragmentUpcomingBinding

    private lateinit var viewModel: UpcomingViewModel

    @Inject
    internal lateinit var layoutManager: GridLayoutManager

    @Inject
    internal lateinit var adapter: UpcomingAdapter

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViewDataBinding().let { binding = it }
        viewModel.navigator = this

        viewModel.fetchUpcoming()

        setupRecyclerview()
        subscribeToLiveData()
    }

    private fun setupRecyclerview() {
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        upcomingRecyclerView.layoutManager = layoutManager
        upcomingRecyclerView.itemAnimator = DefaultItemAnimator()
        upcomingRecyclerView.adapter = adapter
    }

    private fun subscribeToLiveData() {
        viewModel.getUpcomingMovieListLiveData().observe(this, Observer {
            it?.let { viewModel.addUpcomingMovieItemsToList(it) }
        })
    }

    override fun getViewModel(): UpcomingViewModel {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(UpcomingViewModel::class.java)
        return viewModel
    }

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getLayoutId(): Int = R.layout.fragment_upcoming
}
