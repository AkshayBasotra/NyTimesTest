package com.test.xebia.nytimes.data

import android.app.Application
import android.content.Context
import com.test.xebia.nytimes.api.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsRepository(ctx: Application, db: NewsDao) {


    private lateinit var apiService: ApiService
    private lateinit var dao: NewsDao
    lateinit var context: Context

    val news = resultLiveData(
        databaseQuery = { dao.getNews() },
        networkCall = { NewsRemoteDataSource(apiService).fetchNewsList() },
        saveCallResult = { dao.insertAll(it.results) })



     init {
         /*TODO("this gitHubService instance will be injected using Dagger in part #2 ...")*/
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiService.ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        this.context = ctx
        apiService = retrofit.create(ApiService::class.java)
        dao = db

    }




}
