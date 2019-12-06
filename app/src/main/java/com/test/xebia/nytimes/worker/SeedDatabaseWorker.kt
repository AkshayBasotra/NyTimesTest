package com.elifox.legocatalog.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.test.xebia.nytimes.data.AppDatabase
import com.test.xebia.nytimes.NewsList.data.NewsModel
import com.test.xebia.nytimes.util.Constants.DATA_FILENAME
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import timber.log.Timber

class SeedDatabaseWorker(
        context: Context,
        workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result = coroutineScope {
        withContext(Dispatchers.IO) {

            try {
                applicationContext.assets.open(DATA_FILENAME).use { inputStream ->
                    JsonReader(inputStream.reader()).use { jsonReader ->
                        val type = object : TypeToken<List<NewsModel>>() {}.type
                        val list: List<NewsModel> = Gson().fromJson(jsonReader, type)
                        AppDatabase.getInstance(applicationContext).newsDao().insertAll(list)
                        Result.success()
                    }
                }
            } catch (e: Exception) {
                Timber.e(e, "Error seeding database")
                Result.failure()
            }
        }
    }
}