package com.home.androidComposable.utils

import com.home.data.BuildConfig

fun String.imageUrlSmall(): String {
    return "${BuildConfig.MOVIE_IMAGE_SMALL}/$this"
}

fun String.imageUrlLarge(): String {
    return "${BuildConfig.MOVIE_IMAGE_LARGE}/$this"
}

fun String.imageUrlOriginal(): String {
    return "${BuildConfig.MOVIE_IMAGE_ORIGINAL}/$this"
}