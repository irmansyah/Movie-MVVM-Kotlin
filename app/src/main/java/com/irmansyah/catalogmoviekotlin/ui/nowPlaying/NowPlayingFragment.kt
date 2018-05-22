package com.irmansyah.catalogmoviekotlin.ui.nowPlaying


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.irmansyah.catalogmoviekotlin.BR

import com.irmansyah.catalogmoviekotlin.R
import com.irmansyah.catalogmoviekotlin.data.model.Movie
import com.irmansyah.catalogmoviekotlin.databinding.FragmentNowPlayingBinding
import com.irmansyah.catalogmoviekotlin.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_now_playing.*
import javax.inject.Inject

class NowPlayingFragment : BaseFragment<FragmentNowPlayingBinding, NowPlayingViewModel>(), NowPlayingNavigator {

    companion object {
        var TAG = "NowPlayingFragment"

        fun newInstance(): NowPlayingFragment = NowPlayingFragment()
    }

    internal lateinit var binding: FragmentNowPlayingBinding

    private lateinit var viewModel: NowPlayingViewModel

    @Inject
    internal lateinit var mLayoutManager: LinearLayoutManager

    @Inject
    internal lateinit var adapter: NowPlayingAdapter

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViewDataBinding().let { binding = it }
        viewModel.navigator = this

        viewModel.fetchNowPlaying()

        setupRecyclerview()
        subscribeToLiveData()
    }

    private fun setupRecyclerview() {
        mLayoutManager.orientation = LinearLayoutManager.VERTICAL
        nowPlayingRecyclerView.layoutManager = mLayoutManager
        nowPlayingRecyclerView.itemAnimator = DefaultItemAnimator()
        nowPlayingRecyclerView.adapter = adapter
    }

    private fun subscribeToLiveData() {
        viewModel.getNowPlayingMovieListLiveData().observe(this, Observer {
            it?.let { viewModel.addNowPlayingMovieItemsToList(it) }
        })
    }

    override fun getViewModel(): NowPlayingViewModel {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(NowPlayingViewModel::class.java)
        return viewModel
    }

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getLayoutId(): Int = R.layout.fragment_now_playing
}
