package com.anitac.photoexpo.repository


import com.anitac.photoexpo.ImageList
import com.anitac.photoexpo.api.NetworkService
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

/**
 * @author Anita Chipkar
 * @property networkService
 */
class HomeRepository @Inject constructor(
    val networkService: NetworkService
) {

    fun callImageList(): Single<ArrayList<ImageList>> =
        networkService.callImageList()
}