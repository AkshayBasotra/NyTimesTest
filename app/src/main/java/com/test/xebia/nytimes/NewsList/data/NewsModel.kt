package com.test.xebia.nytimes.NewsList.data

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.*
import com.google.gson.annotations.SerializedName
import com.test.xebia.nytimes.data.DataConverter
import java.util.*

@Entity(tableName = "news")
data class NewsModel(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    @field:SerializedName("title")
    var title: String? = null,
    @field:SerializedName("abstract")
    var abstract: String? = null,
    @field:SerializedName("published_date")
    var published_date: String? = null,
    @field:SerializedName("source")
    var source: String? = null,
    @field:SerializedName("views")
    var views: Int = 0,
    @field:SerializedName("byline")
    var byline: String? =  null
/*@Ignore
@field:SerializedName("media")
var media: MediaModel? = null*/


)