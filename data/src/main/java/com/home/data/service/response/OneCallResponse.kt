package com.home.data.service.response

import com.google.gson.annotations.SerializedName
import com.home.data.model.Current
import com.home.data.model.Daily
import com.home.data.model.Hourly

data class OneCallResponse(
    @SerializedName("lat") val lat: Double,
    @SerializedName("lon") val lon: Double,
    @SerializedName("timezone") val timezone: String,
    @SerializedName("timezone_offset") val timezoneOffset: Int,
    @SerializedName("current") val current: Current,
    @SerializedName("hourly") val hourly: List<Hourly>?,
    @SerializedName("daily") val daily: List<Daily>?
)