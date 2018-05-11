package com.irmansyah.catalogmoviekotlin.ui.main

import com.irmansyah.catalogmoviekotlin.data.DataManager
import com.irmansyah.catalogmoviekotlin.utils.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    internal fun provideMainViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider)
            : MainViewModel = MainViewModel(dataManager, schedulerProvider)
}