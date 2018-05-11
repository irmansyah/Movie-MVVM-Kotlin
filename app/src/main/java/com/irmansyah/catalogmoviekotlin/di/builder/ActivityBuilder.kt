package com.irmansyah.catalogmoviekotlin.di.builder

import com.irmansyah.catalogmoviekotlin.ui.main.MainActivity
import com.irmansyah.catalogmoviekotlin.ui.main.MainActivityModule
import com.irmansyah.catalogmoviekotlin.ui.nowPlaying.NowPlayingFragmentProvider
import com.irmansyah.catalogmoviekotlin.ui.upcoming.UpcomingFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(MainActivityModule::class), (NowPlayingFragmentProvider::class), (UpcomingFragmentProvider::class)])
    abstract fun bindMainActivity(): MainActivity
}