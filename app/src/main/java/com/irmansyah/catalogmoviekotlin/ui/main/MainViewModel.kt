package com.irmansyah.catalogmoviekotlin.ui.main

import com.irmansyah.catalogmoviekotlin.data.DataManager
import com.irmansyah.catalogmoviekotlin.ui.base.BaseViewModel
import com.irmansyah.catalogmoviekotlin.utils.SchedulerProvider

class MainViewModel constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<MainNavigator>(dataManager = dataManager, schedulerProvider = schedulerProvider) {


}