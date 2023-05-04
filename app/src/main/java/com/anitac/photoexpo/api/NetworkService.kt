package com.anitac.photoexpo.api

import com.anitac.photoexpo.ImageList
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

/**
 * NetworkService class for API calling
 */
@Singleton
interface NetworkService {

    @GET("photos")
    fun callImageList(
    ): Single<ArrayList<ImageList>>
}