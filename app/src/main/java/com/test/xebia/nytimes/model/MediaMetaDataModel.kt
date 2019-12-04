package com.test.xebia.nytimes.model

import com.google.gson.annotations.SerializedName

data class MediaMetaDataModel(
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("format")
    val format: String? = null,
    @SerializedName("height")
    val height: Int,
    @SerializedName("width")
    val width: Int
)