package com.irmansyah.catalogmoviekotlin.ui.nowPlaying


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.irmansyah.catalogmoviekotlin.BR

import com.irmansyah.catalogmoviekotlin.R
import com.irmansyah.catalogmoviekotlin.databinding.FragmentNowPlayingBinding
import com.irmansyah.catalogmoviekotlin.ui.base.BaseFragment
import javax.inject.Inject

class NowPlayingFragment : BaseFragment<FragmentNowPlayingBinding, NowPlayingViewModel>(), NowPlayingNavigator {

    companion object {
        var TAG = "NowPlayingFragment"

        fun newInstance(): NowPlayingFragment = NowPlayingFragment()
    }

    internal lateinit var binding: FragmentNowPlayingBinding

    @Inject
    internal lateinit var viewModel: NowPlayingViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViewDataBinding()?.let { binding = it }
        viewModel.navigator = this
    }

    override fun getViewModel(): NowPlayingViewModel = viewModel

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getLayoutId(): Int = R.layout.fragment_now_playing
}
