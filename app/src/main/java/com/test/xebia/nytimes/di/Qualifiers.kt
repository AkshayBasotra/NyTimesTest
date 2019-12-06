package com.test.xebia.nytimes.di

import javax.inject.Qualifier


@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class NewsAPI

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class CoroutineScropeIO
