package com.anitac.photoexpo.api

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
/**
 * @author Anita Chipkar
 * @constructor
 * @param context
 */
class TokenAuth(context: Context) : Interceptor {
    var mContext: Context = context
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val builder = request.newBuilder()
        builder.header("Accept", "application/json")
        request = builder.build()
        return chain.proceed(request)
    }
}

