package com.test.xebia.nytimes.model

import com.google.gson.annotations.SerializedName

data class NewsModel (
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("abstract")
    val abstract: String? = null,
    @SerializedName("published_date")
    val published_date: String? = null,
    @SerializedName("source")
    val source: String? = null,
    @SerializedName("views")
    val views: Int,
    @SerializedName("media")
    val media: MediaModel? = null

)