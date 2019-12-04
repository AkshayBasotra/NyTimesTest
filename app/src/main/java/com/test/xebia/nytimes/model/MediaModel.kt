package com.test.xebia.nytimes.model

import com.google.gson.annotations.SerializedName

data class MediaModel (
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("caption")
    val caption: String? = null,
    @SerializedName("copyright")
    val copyright: String? = null,
    @SerializedName("media-metadata")
    val media_metadata: List<MediaMetaDataModel>? = null


)