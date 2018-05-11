package com.irmansyah.catalogmoviekotlin.ui.upcoming

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UpcomingFragmentProvider {

    @ContributesAndroidInjector(modules = [(UpcomingFragmentModule::class)])
    internal abstract fun provideUpcomingFragmentFactory(): UpcomingFragment
}