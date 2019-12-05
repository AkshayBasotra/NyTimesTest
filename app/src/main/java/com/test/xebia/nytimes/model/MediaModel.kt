package com.test.xebia.nytimes.model

import androidx.room.Embedded
import androidx.room.Ignore
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.test.xebia.nytimes.data.DataConverter

 class MediaModel {
     @SerializedName("type")
     var type: String? = null
     @SerializedName("caption")
     var caption: String? = null
     @SerializedName("copyright")
     var copyright: String? = null
     @Embedded
     @SerializedName("media-metadata")
     var media_metadata: List<MediaMetaDataModel>? = null
 }