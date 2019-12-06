package com.test.xebia.nytimes.newsList.data

import androidx.room.*
import com.google.gson.annotations.SerializedName
import com.test.xebia.nytimes.model.MediaModel

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
    var byline: String? = null,

    @field:SerializedName("media")
    var media: List<MediaModel>? = null


)