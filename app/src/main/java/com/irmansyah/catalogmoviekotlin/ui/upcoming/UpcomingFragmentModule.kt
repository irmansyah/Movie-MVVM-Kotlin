package com.irmansyah.catalogmoviekotlin.ui.upcoming

import com.irmansyah.catalogmoviekotlin.data.DataManager
import com.irmansyah.catalogmoviekotlin.utils.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class UpcomingFragmentModule {

    @Provides
    internal fun provideUpcomingViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider)
            : UpcomingViewModel = UpcomingViewModel(dataManager, schedulerProvider)
}