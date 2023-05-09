package com.anitac.photoexpo.repository


import com.anitac.photoexpo.api.NetworkService
import javax.inject.Inject

/**
 * @author Anita Chipkar
 * @property networkService
 */
class DetailsRepository @Inject constructor(
    val networkService: NetworkService
) {
}