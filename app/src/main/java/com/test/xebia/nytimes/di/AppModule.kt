package com.test.xebia.nytimes.di

import android.app.Application
import com.test.xebia.nytimes.api.ApiService
import com.test.xebia.nytimes.data.AppDatabase
import com.test.xebia.nytimes.NewsList.data.NewsRemoteDataSource
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, NetworkingModule::class])
class AppModule {
    @Singleton
    @Provides
    fun provideApiService(@NewsAPI okhttpClient: OkHttpClient,
                           converterFactory: GsonConverterFactory
    ) = provideService(okhttpClient, converterFactory, ApiService::class.java)

    @Singleton
    @Provides
    fun provideLegoSetRemoteDataSource(apiService: ApiService)
            =
        NewsRemoteDataSource(apiService)



    @NewsAPI
    @Provides
    fun providePrivateOkHttpClient(
        upstreamClient: OkHttpClient
    ): OkHttpClient {
        return upstreamClient.newBuilder().build()
    }

    @Singleton
    @Provides
    fun provideDb(app: Application) = AppDatabase.getInstance(app)

    @Singleton
    @Provides
    fun provideNewsDao(db: AppDatabase) = db.newsDao()


    @CoroutineScropeIO
    @Provides
    fun provideCoroutineScopeIO() = CoroutineScope(Dispatchers.IO)


    private fun createRetrofit(
        okhttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiService.ENDPOINT)
            .client(okhttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }

    private fun <T> provideService(okhttpClient: OkHttpClient,
                                   converterFactory: GsonConverterFactory, clazz: Class<T>): T {
        return createRetrofit(okhttpClient, converterFactory).create(clazz)
    }
}