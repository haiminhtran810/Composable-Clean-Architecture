package com.home.data.service.interceptor

import android.os.Build
import com.home.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val newUrl =
            request.url.newBuilder().addQueryParameter(API_KEY, BuildConfig.MOVIE_APP_ID).build()
        request = request.newBuilder()
            .url(newUrl)
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "application/json")
            .addHeader("OS", "Android-${Build.VERSION.SDK_INT}")
            //.addHeader("Version", BuildConfig.VERSION_NAME)
            .build()
        return chain.proceed(request)
    }

    companion object {
        const val API_KEY = "api_key"
    }
}