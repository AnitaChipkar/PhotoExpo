package com.anitac.photoexpo.api


import com.anitac.photoexpo.AppApplication
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author Anita Chipkar
 * @since 13/06/2022
 * Networking
 * @constructor Create empty Networking
 */
object Networking {
    private const val NETWORK_CALL_TIMEOUT = 60
    private lateinit var API_KEY: String
    fun create(
        apiKey: String,
        baseUrl: String,
        application: AppApplication
    ): NetworkService {
        HttpLoggingInterceptor.Level.BODY

        /**
         * Code to create Retrofit api call
         */
        API_KEY = apiKey
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(TokenAuth(application))
                    .addInterceptor(
                        HttpLoggingInterceptor()
                            .apply {
                                level = HttpLoggingInterceptor.Level.BODY
                            })
                    .addInterceptor(RequestInterceptor(object :
                        RequestInterceptor.OnRequestInterceptor { //to provide common header & params
                        override fun provideHeaderMap(): HashMap<String, String> {
                           // val map = HashMap<String, String>()
                           /* if (sharedPreference.authToken?.isNotEmpty() == true)
                                map["AUTHTOKEN"] = sharedPreference.authToken.toString()*/
                            return HashMap()
                        }

                        override fun provideBodyMap(): HashMap<String, String> {
                            return HashMap()
                        }
                    }))
                    .readTimeout(NETWORK_CALL_TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .writeTimeout(NETWORK_CALL_TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .connectTimeout(NETWORK_CALL_TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .build()
            )
            .addConverterFactory(JacksonConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(NetworkService::class.java)
    }
}