package com.anitac.photoexpo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.anitac.photoexpo.api.NetworkService
import com.anitac.photoexpo.viewmodel.HomeViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import rx.Single

@RunWith(JUnit4::class)
class HomeViewModelTest {
    var homeViewModel: HomeViewModel?=null
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var mockApiService: NetworkService

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }
    @Test
    fun `verify images data from API`()  {
        // Create some test data
        val testData = ImageList(1, 1,
            "Item 3","Item 4","Item 5")
        `when`(mockApiService.callImageList()).thenReturn(Single.just(testData))
        homeViewModel?.callGetImageList()
        // Verify that the ViewModel's LiveData emits the expected data
        homeViewModel?.imageListLiveData?.observeForever { data ->
            assertEquals(testData, data)
        }
    }
}

private fun Any.thenReturn(just: Single<ImageList>?) {

}
