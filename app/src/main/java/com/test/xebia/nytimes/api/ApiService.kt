package com.test.xebia.nytimes.api

import com.test.xebia.nytimes.model.NewsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    companion object {
        const val ENDPOINT = "https://api.nytimes.com/svc/"
    }

    @GET("mostpopular/v2/viewed/1.json?api-key=uhGpRWaUac64bfxUuGLYC2slLoQVFrFu")
    suspend fun getMostPopularNews(): Response<ResultsResponse<NewsModel>>

}