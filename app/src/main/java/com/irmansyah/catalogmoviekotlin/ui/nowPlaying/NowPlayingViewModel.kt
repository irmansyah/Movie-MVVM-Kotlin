package com.irmansyah.catalogmoviekotlin.ui.nowPlaying

import com.irmansyah.catalogmoviekotlin.data.DataManager
import com.irmansyah.catalogmoviekotlin.ui.base.BaseViewModel
import com.irmansyah.catalogmoviekotlin.utils.SchedulerProvider

class NowPlayingViewModel constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<NowPlayingNavigator>(dataManager = dataManager, schedulerProvider = schedulerProvider) {
}