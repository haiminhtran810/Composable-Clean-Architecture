package com.home.data.service.builder

import com.home.data.mapper.ExceptionMapper
import com.home.data.service.factory.FlowCallAdapterFactory
import com.home.data.service.interceptor.TokenAuthenticator
import com.home.data.util.Constants
import com.home.domain.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitBuilder(private val exceptionMapper: ExceptionMapper) {
    companion object {
        const val HEADER_AUTHORIZATION = "HEADER_AUTHORIZATION"
    }

    private var connectionTimeout = Constants.HttpClient.CONNECT_TIMEOUT
    private var writeTimeout = Constants.HttpClient.WRITE_TIMEOUT
    private var readTimeout = Constants.HttpClient.READ_TIMEOUT
    private val okHttpClient = makeOkHttpClient(makeLoggingInterceptor(BuildConfig.DEBUG))

    private val tokenAuthenticator = TokenAuthenticator()

    //private val okHttpClient = make
    private fun makeOkHttpClient(httpLoggingInterceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(connectionTimeout, TimeUnit.SECONDS)
            .writeTimeout(writeTimeout, TimeUnit.SECONDS)
            .readTimeout(readTimeout, TimeUnit.SECONDS)
            .authenticator(tokenAuthenticator)
            .addInterceptor(httpLoggingInterceptor).build()
    }

    private fun makeLoggingInterceptor(isDebug: Boolean): Interceptor {
        return HttpLoggingInterceptor().apply {
            level = if (isDebug) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }

        }
    }

    private fun getUrl() = "Weather API URL"

     fun build(): Retrofit {
        return Retrofit.Builder().baseUrl(getUrl()).client(okHttpClient)
            .addCallAdapterFactory(FlowCallAdapterFactory.create(exceptionMapper = exceptionMapper))
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}