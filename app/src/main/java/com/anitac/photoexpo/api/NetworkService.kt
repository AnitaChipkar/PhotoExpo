package com.anitac.photoexpo.api

import com.anitac.photoexpo.ImageList
import io.reactivex.Single
import retrofit2.http.GET
import javax.inject.Singleton

/**
 * @author Anita Chipkar
 * NetworkService class for API calling
 */
@Singleton
interface NetworkService {

    @GET("photos")
    fun callImageList(
    ): Single<ArrayList<ImageList>>
}