package com.test.xebia.nytimes.data

import com.test.xebia.nytimes.api.ApiService
import com.test.xebia.nytimes.util.Constants

class NewsRemoteDataSource (private val apiService: ApiService): BaseDataSource() {
    suspend fun fetchNewsList() = getResult{apiService.getMostPopularNews(Constants.API_KEY)}
}