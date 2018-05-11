package com.irmansyah.catalogmoviekotlin.ui.nowPlaying

import com.irmansyah.catalogmoviekotlin.data.DataManager
import com.irmansyah.catalogmoviekotlin.utils.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class NowPlayingFragmentModule {

    @Provides
    internal fun provideNowPlayingViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider)
            : NowPlayingViewModel = NowPlayingViewModel(dataManager, schedulerProvider)
}