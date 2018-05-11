package com.irmansyah.catalogmoviekotlin.ui.nowPlaying

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class NowPlayingFragmentProvider {

    @ContributesAndroidInjector(modules = [(NowPlayingFragmentModule::class)])
    internal abstract fun provideNowPlayingFragmentFactory(): NowPlayingFragment
}