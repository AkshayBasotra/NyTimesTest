package com.test.xebia.nytimes.di

import com.test.xebia.nytimes.NewsList.ui.NewsListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeNewsListFragment(): NewsListFragment
}