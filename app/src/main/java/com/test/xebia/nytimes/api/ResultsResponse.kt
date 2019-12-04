package com.test.xebia.nytimes.api

import com.google.gson.annotations.SerializedName

data class ResultsResponse<T> (
    @SerializedName("num_results")
    val num_results: Int,
    @SerializedName("copyright")
    val copyright: String? = null,
    @SerializedName("status")
    val status: String? = null,
    @SerializedName("results")
    val results: List<T>
)