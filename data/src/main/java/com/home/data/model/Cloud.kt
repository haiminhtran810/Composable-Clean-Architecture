package com.home.data.model

import com.google.gson.annotations.SerializedName
import com.home.data.base.DataModel

data class Cloud(
    @SerializedName("all")
    val all: Int
) : DataModel()
