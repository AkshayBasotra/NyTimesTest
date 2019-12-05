package com.test.xebia.nytimes.data

import com.test.xebia.nytimes.api.ApiService

class NewsRemoteDataSource (private val apiService: ApiService): BaseDataSource() {
    suspend fun fetchNewsList() = getResult{apiService.getMostPopularNews()}
}