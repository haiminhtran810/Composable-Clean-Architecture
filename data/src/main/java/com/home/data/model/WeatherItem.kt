package com.home.data.model

import com.google.gson.annotations.SerializedName
import com.home.data.base.DataModel

class WeatherItem(
    @SerializedName("id") val id: Int,
    @SerializedName("main") val main: String,
    @SerializedName("description") val description: String?,
    @SerializedName("icon") val icon: String?
) : DataModel()