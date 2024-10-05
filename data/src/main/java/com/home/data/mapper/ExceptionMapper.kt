package com.home.data.mapper

import android.content.Context

class ExceptionMapper {
//    fun mapperToBaseException(throwable: RetrofitException): Throwable {
//
//        return when (throwable.getKind()) {
//            RetrofitException.Kind.NETWORK ->
//                BaseException.SnackBarException(
//                    code = -1,
//                    message = context.getString(R.string.internet_connection_error)
//                )
//
//            RetrofitException.Kind.HTTP ->
//                BaseException.OnPageException(
//                    code = throwable.getResponse()?.code() ?: -1,
//                    message = String.format(
//                        context.getString(R.string.url_invalid),
//                        throwable.getRetrofit()?.baseUrl() ?: ""
//                    )
//                )
//
//            RetrofitException.Kind.HTTP_422_WITH_DATA ->
//                BaseException.OnPageException(
//                    code = throwable.getErrorData()?.code ?: -1,
//                    message = throwable.getErrorData()?.message?.let {
//                        "${
//                            String.format(
//                                context.getString(R.string.error_code_title),
//                                throwable.getErrorData()?.code
//                            )
//                        }\n $it"
//                    } ?: String.format(
//                        context.getString(R.string.url_invalid),
//                        throwable.getRetrofit()?.baseUrl() ?: ""
//                    )
//                )
//
//            else -> throwable
//        }
//    }
}