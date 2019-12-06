package com.test.xebia.nytimes.api

import com.test.xebia.nytimes.NewsList.data.NewsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    companion object {
        const val ENDPOINT = "https://api.nytimes.com/svc/"
    }

    @GET("mostpopular/v2/viewed/1.json")
    suspend fun getMostPopularNews(@Query("api-key") apiKey: String): Response<ResultsResponse<NewsModel>>

}