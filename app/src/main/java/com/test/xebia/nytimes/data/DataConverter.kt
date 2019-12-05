package com.test.xebia.nytimes.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.test.xebia.nytimes.model.MediaMetaDataModel
import com.test.xebia.nytimes.model.MediaModel

class DataConverter {
    @TypeConverter
    fun listToString(value: List<MediaMetaDataModel>): String {
        val gson = Gson()
        val type = object : TypeToken<List<MediaMetaDataModel>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun stringToList(value: String): List<MediaMetaDataModel> {
        val gson = Gson()
        val type = object : TypeToken<List<MediaMetaDataModel>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun objectToString(value: MediaModel): String {
        val gson = Gson()
        val type = object : TypeToken<List<MediaMetaDataModel>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun stringToObject(value: String): MediaModel {
        val gson = Gson()
        val type = object : TypeToken<List<MediaMetaDataModel>>() {}.type
        return gson.fromJson(value, type)
    }
}