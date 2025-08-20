package com.home.androidComposable.utils

import android.content.Context

fun Context.appVersionCode(): Int {
    return try {
        val pInfo = packageManager.getPackageInfo(packageName, 0)
        val version = pInfo.versionCode
        version
    } catch (e: Exception) {
        0
    }
}

fun Context.appVersionName(): String {
    return try {
        val pInfo = packageManager.getPackageInfo(packageName, 0)
        val version = pInfo.versionName
        version
    } catch (e: Exception) {
        "---"
    }
}

