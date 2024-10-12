package com.home.data.service.interceptor

import com.home.data.model.TokenResponseModel
import com.home.data.service.api.WeatherApi
import com.home.data.service.builder.RetrofitBuilder.Companion.HEADER_AUTHORIZATION
import com.home.data.storages.pref.PreferenceStorage
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import timber.log.Timber
import java.util.Calendar
import java.util.concurrent.CountDownLatch

const val MIN_WINDOW_TIME_2_REFRESH_TOKEN_CALLS = 300_000L

class TokenAuthenticator : Authenticator, KoinComponent {
    private var countDownLatch: CountDownLatch? = null
    private val weatherApi: WeatherApi by inject()
    private val pref: PreferenceStorage by inject()
    private var lastRefreshToken = 0L

    override fun authenticate(route: Route?, response: Response): Request? {
        val authToken = getToken(response)
        return if (authToken) {
            buildNewRequest(response)
        } else {
            // Fail when refresh token
            null
        }
    }

    @Synchronized
    private fun getToken(response: Response): Boolean {
        if (pref.accessToken.isNullOrEmpty() || pref.refreshToken.isNullOrEmpty()) {
            Timber.d("AccessToken and RefreshToken are null")
            return false
        }
        if ((countDownLatch != null && countDownLatch!!.count > 0L) || elapsedTimeFromLastRefreshToken() < MIN_WINDOW_TIME_2_REFRESH_TOKEN_CALLS) {
            Timber.d("Wait countDownLatch locked ${response.request.url}")
            countDownLatch?.await()
            Timber.d("Wait countDownLatch locked $pref.refreshToken")
            return true
        }
        Timber.d("CountDownLatch locked ${response.request.url}")
        val newToken = refreshToken()
        Timber.d("CountDownLatch unlocked")
        countDownLatch?.countDown()
        return newToken
    }

    @Synchronized
    private fun refreshToken(): Boolean {
        if (pref.accessToken.isNullOrEmpty() || pref.refreshToken.isNullOrEmpty()) {
            Timber.d("AccessToken and RefreshToken are null")
            return false
        }
        val accessToken = pref.accessToken
        val refreshToken = pref.refreshToken
        val authTokenResponse = refreshTokenNonSuspendFake(accessToken, refreshToken)
        pref.accessToken = authTokenResponse.accessToken
        pref.refreshToken = authTokenResponse.refreshToken
        if (authTokenResponse.accessToken != null) {
            lastRefreshToken = System.currentTimeMillis()
        }
        Timber.d("RefreshToken: ${authTokenResponse.refreshToken}")
        return authTokenResponse.accessToken != null && authTokenResponse.refreshToken != null
    }

    private fun elapsedTimeFromLastRefreshToken(): Long {
        return System.currentTimeMillis() - lastRefreshToken
    }

    private fun getCountLatch(): CountDownLatch? {
        return countDownLatch
    }

    private fun refreshTokenNonSuspendFake(
        accessToken: String?, refreshToken: String?
    ): TokenResponseModel {
        val calendarString = Calendar.getInstance().toString()
        val fakeCallAPI = weatherApi.toString() + accessToken + refreshToken
        return TokenResponseModel(
            accessToken = "NewAccessToken$calendarString",
            refreshToken = "NewRefreshToken$calendarString",
            expire = calendarString,
        )
    }

    private fun buildNewRequest(response: Response): Request {
        val accessToken = pref.accessToken ?: ""
        Timber.d("buildNewRequest: $accessToken")
        return response.request.newBuilder()
            .addHeader(HEADER_AUTHORIZATION, "bear $accessToken")
            .build()
    }
}