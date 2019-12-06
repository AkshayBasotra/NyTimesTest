package com.test.xebia.nytimes.newsList.data

import com.test.xebia.nytimes.api.ApiService
import com.test.xebia.nytimes.api.BaseDataSource
import com.test.xebia.nytimes.util.Constants
import javax.inject.Inject

class NewsRemoteDataSource @Inject constructor(private val apiService: ApiService): BaseDataSource() {
    suspend fun fetchNewsList() = getResult{apiService.getMostPopularNews(Constants.API_KEY)}
}