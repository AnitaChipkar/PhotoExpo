package com.anitac.photoexpo.api

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import javax.inject.Singleton

/**
 * @author Anita Chipkar
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
        val network = connectivityManager.activeNetwork
        val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
        var networkInfo = capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
        if (!networkInfo)
            networkInfo = capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
        return networkInfo
    }

}