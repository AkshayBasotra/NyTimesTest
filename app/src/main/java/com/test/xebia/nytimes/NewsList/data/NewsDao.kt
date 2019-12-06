package com.test.xebia.nytimes.NewsList.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.test.xebia.nytimes.NewsList.data.NewsModel

@Dao
interface NewsDao {
    @Query("SELECT * FROM news ORDER BY id DESC")
    fun getNews(): LiveData<List<NewsModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(plants: List<NewsModel>)
}