package com.home.data.service.response

import com.google.gson.annotations.SerializedName
import com.home.domain.model.weather.Current
import com.home.domain.model.weather.Daily
import com.home.domain.model.weather.Hourly

data class OneCallResponse(
    @SerializedName("lat") val lat: Double,
    @SerializedName("lon") val lon: Double,
    @SerializedName("timezone") val timezone: String,
    @SerializedName("timezone_offset") val timezoneOffset: Int,
    @SerializedName("current") val current: Current,
    @SerializedName("hourly") val hourly: List<Hourly>?,
    @SerializedName("daily") val daily: List<Daily>?
)