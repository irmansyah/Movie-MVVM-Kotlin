package com.irmansyah.catalogmoviekotlin.ui.nowPlaying

import android.arch.lifecycle.ViewModelProvider
import android.support.v7.widget.LinearLayoutManager
import com.irmansyah.catalogmoviekotlin.ViewModelProviderFactory
import com.irmansyah.catalogmoviekotlin.data.DataManager
import com.irmansyah.catalogmoviekotlin.utils.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class NowPlayingFragmentModule {

    @Provides
    internal fun provideNowPlayingViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider)
            : NowPlayingViewModel = NowPlayingViewModel(dataManager, schedulerProvider)

    @Provides
    internal fun provideNowPlayingViewModelProviderFactory(viewModel: NowPlayingViewModel)
            : ViewModelProvider.Factory = ViewModelProviderFactory(viewModel)

    @Provides
    internal fun provideNowPlayingAdapter(dataManager: DataManager, schedulerProvider: SchedulerProvider)
            : NowPlayingAdapter = NowPlayingAdapter(ArrayList(), dataManager = dataManager, schedulerProvider = schedulerProvider)

    @Provides
    internal fun provideLinearLayoutManager(fragment: NowPlayingFragment): LinearLayoutManager = LinearLayoutManager(fragment.activity)
}