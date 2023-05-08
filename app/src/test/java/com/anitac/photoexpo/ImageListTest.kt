package com.anitac.photoexpo

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


class ImageListTest {
    val albumId: Int? = null
    val id: Int? = null
    val title: String? = null
    val url: String = "https://via.placeholder.com"
    val thumbnailUrl: String? = null

    @Mock
    var imageList: ImageList? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Mockito.`when`(imageList?.albumId).thenReturn(albumId)
        Mockito.`when`(imageList?.id).thenReturn(id)
        Mockito.`when`(imageList?.title).thenReturn(title)
        Mockito.`when`(imageList?.url).thenReturn(url)
        Mockito.`when`(imageList?.thumbnailUrl).thenReturn(thumbnailUrl)
    }

    @Test
    fun testImageUrl() {
        Mockito.`when`(imageList?.url).thenReturn(url)
        Assert.assertEquals("https://via.placeholder.com", imageList?.url)
    }

}