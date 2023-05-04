package com.anitac.photoexpo.api

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import javax.inject.Singleton

/**
 * @author Anita Chipkar
 * @since 13/06/2022
 * @property context
 */
@Suppress("DEPRECATION")
@Singleton
class NetworkHelper constructor(private val context: Context) {
    companion object {
        private const val TAG = "NetworkHelper"
    }
    fun isNetworkConnected(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork
            val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
            var networkInfo = capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
            if (!networkInfo)
                networkInfo = capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
            return networkInfo
        } else {
            var networkInfo =
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE) ?: return false
            if (!networkInfo.isConnected) {
                networkInfo =
                    connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                        ?: return false
            }
            return networkInfo.isConnected
        }
    }

}