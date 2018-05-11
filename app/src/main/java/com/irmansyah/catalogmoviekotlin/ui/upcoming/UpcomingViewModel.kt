package com.irmansyah.catalogmoviekotlin.ui.upcoming

import com.irmansyah.catalogmoviekotlin.data.DataManager
import com.irmansyah.catalogmoviekotlin.ui.base.BaseViewModel
import com.irmansyah.catalogmoviekotlin.utils.SchedulerProvider

class UpcomingViewModel constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider)  : BaseViewModel<UpcomingNavigator>(dataManager = dataManager, schedulerProvider = schedulerProvider) {
}