package com.anitac.photoexpo

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonIgnoreProperties(ignoreUnknown = true)
data class ImageList(
    @JsonProperty("albumId")
    @Expose
    val albumId: Int? = null,
    @JsonProperty("id")
    @Expose
    val id: Int? = null,
    @JsonProperty("title")
    @Expose
    val title: String? = null,
    @JsonProperty("url")
    @Expose
    val url: String? = null,
    @JsonProperty("thumbnailUrl")
    @Expose
    val thumbnailUrl: String? = null
) : Parcelable {

}