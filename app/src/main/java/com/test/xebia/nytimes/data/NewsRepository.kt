package com.test.xebia.nytimes.data

import com.test.xebia.nytimes.api.ApiService

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsRepository private constructor() {
    private lateinit var apiService: ApiService



   /* // TODO better error handling in part #2 ...
    val newsList: LiveData<List<NewsRepository>>
        get() {
            val data = MutableLiveData<List<NewsModel>>()
            apiService.getMostPopularNews().enqueue(object : Callback<ResultsResponse<NewsModel>> {
                override fun onResponse(
                    call: Call<ResultsResponse<NewsModel>>,
                    response: Response<ResultsResponse<NewsModel>>
                ) {

                }

                override fun onFailure(call: Call<ResultsResponse<NewsModel>>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })


        }*/

    init {
         TODO("this gitHubService instance will be injected using Dagger in part #2 ...")
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiService.ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java)
    }

    companion object {
        private var newsRepository: NewsRepository? = null
        //TODO("No need to implement this singleton in Part #2 since Dagger will handle it ...")
        val instance: NewsRepository
            @Synchronized get() {
                if (newsRepository == null) {
                    newsRepository =
                        NewsRepository()
                }
                return newsRepository!!
            }
    }


}
