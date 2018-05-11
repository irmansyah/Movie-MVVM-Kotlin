package com.irmansyah.catalogmoviekotlin.ui.upcoming


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.irmansyah.catalogmoviekotlin.BR

import com.irmansyah.catalogmoviekotlin.R
import com.irmansyah.catalogmoviekotlin.databinding.FragmentUpcomingBinding
import com.irmansyah.catalogmoviekotlin.ui.base.BaseFragment
import javax.inject.Inject

class UpcomingFragment : BaseFragment<FragmentUpcomingBinding, UpcomingViewModel>(), UpcomingNavigator {

    companion object {
        var TAG = "UpcomingFragment"

        fun newInstance(): UpcomingFragment = UpcomingFragment()
    }

    internal lateinit var binding: FragmentUpcomingBinding

    @Inject
    internal lateinit var viewModel: UpcomingViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViewDataBinding()?.let { binding = it }
        viewModel.navigator = this
    }

    override fun getViewModel(): UpcomingViewModel = viewModel

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getLayoutId(): Int = R.layout.fragment_upcoming
}
