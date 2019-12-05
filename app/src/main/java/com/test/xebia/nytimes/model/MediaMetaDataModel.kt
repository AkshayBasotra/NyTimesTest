package com.test.xebia.nytimes.model

import androidx.room.Entity
import androidx.room.Ignore
import com.google.gson.annotations.SerializedName

 class MediaMetaDataModel {
     @SerializedName("url")
     var url: String? = null
     @SerializedName("format")
     var format: String? = null
     @SerializedName("height")
     var height: Int = 0
     @SerializedName("width")
     var width: Int = 0
 }

