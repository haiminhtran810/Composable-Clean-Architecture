package com.home.domain.model.errors

import com.example.weather.domain.annotation.TagName

data class Tag(@TagName val name: String, val message: String?)