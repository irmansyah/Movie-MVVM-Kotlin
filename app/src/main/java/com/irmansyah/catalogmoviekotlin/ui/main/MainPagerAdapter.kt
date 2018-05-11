package com.irmansyah.catalogmoviekotlin.ui.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.irmansyah.catalogmoviekotlin.ui.nowPlaying.NowPlayingFragment
import com.irmansyah.catalogmoviekotlin.ui.upcoming.UpcomingFragment

class MainPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    private var tabCount = 0

    override fun getCount(): Int {
        return tabCount
    }

    override fun getItem(position: Int): Fragment? {
        return when (position) {
            0 -> NowPlayingFragment.newInstance()
            1 -> UpcomingFragment.newInstance()
            else -> null
        }
    }

    internal fun setCount(count: Int) {
        this.tabCount = count
    }

}