package com.irmansyah.catalogmoviekotlin.ui.main

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import com.irmansyah.catalogmoviekotlin.BR
import com.irmansyah.catalogmoviekotlin.R
import com.irmansyah.catalogmoviekotlin.databinding.ActivityMainBinding
import com.irmansyah.catalogmoviekotlin.ui.base.BaseActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), HasSupportFragmentInjector, MainNavigator {

    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    internal lateinit var mainPagerAdapter: MainPagerAdapter

    @Inject
    internal lateinit var viewModel: MainViewModel

    internal lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getViewDataBinding()?.let { binding = it }
        viewModel.navigator = this

        mainPagerAdapter = MainPagerAdapter(supportFragmentManager)
        setUpFeedPagerAdapter()
    }

    override fun getViewModel(): MainViewModel = viewModel

    override fun getBindingVariable(): Int = BR.viewModel

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onFragmentAttached() { }

    override fun onFragmentDetached(tag: String) { }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? = fragmentDispatchingAndroidInjector

    private fun setUpFeedPagerAdapter() {
        mainPagerAdapter.count = 2
        main_view_pager.adapter = mainPagerAdapter
        tab_layout.addTab(tab_layout.newTab().setText(R.string.now_playing_fragment))
        tab_layout.addTab(tab_layout.newTab().setText(R.string.upcoming_fragment))
        main_view_pager.offscreenPageLimit = tab_layout.tabCount
        main_view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) { }

            override fun onTabUnselected(tab: TabLayout.Tab?) { }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let { main_view_pager.currentItem = it.position }
            }
        })
    }
}
