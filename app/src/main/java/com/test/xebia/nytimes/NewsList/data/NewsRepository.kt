package com.test.xebia.nytimes.NewsList.data


import com.test.xebia.nytimes.data.resultLiveData
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class NewsRepository @Inject constructor(private val dao: NewsDao, private val remoteDataSource: NewsRemoteDataSource) {



    val news = resultLiveData(
        databaseQuery = { dao.getNews() },
        networkCall = { remoteDataSource.fetchNewsList() },
        saveCallResult = { dao.insertAll(it.results) })


}
