package com.bimm.takehomeassignmnent

import com.bimm.takehomeassignmnent.domain.interfaces.repository.SakeShopRepository
import com.bimm.takehomeassignmnent.domain.model.ResponseBase
import com.bimm.takehomeassignmnent.domain.model.Shop
import com.bimm.takehomeassignmnent.ui.shopList.ShopListViewModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import org.robolectric.RobolectricTestRunner
import java.util.ArrayList

@RunWith(RobolectricTestRunner::class)
class ShopListViewModelTest {

    private val shopRepository = mock<SakeShopRepository>()
    private val viewModel = ShopListViewModel(shopRepository)

    @Test
    fun loadData_ShouldLoadData() = runBlocking {
        whenever(shopRepository.getShopList()).thenReturn(
            ResponseBase<ArrayList<Shop>>(
                value = ArrayList(listOf(Shop("test"))),
                errors = null,
                success = true
            )
        )

        viewModel.loadData()

        verify(shopRepository, times(1)).getShopList()
        Assert.assertEquals(1, viewModel.shops.count())
        Assert.assertNull(viewModel.selectedShop)
    }

    @Test
    fun initialState_isEmpty() {
        Assert.assertTrue(viewModel.shops.isEmpty())
        Assert.assertNull(viewModel.selectedShop)
    }

    @Test
    fun loadData_handlesFailureGracefully() = runBlocking {
        whenever(shopRepository.getShopList()).thenReturn(
            ResponseBase(value = null, errors = "Error", success = false)
        )

        viewModel.loadData()

        Assert.assertTrue(viewModel.shops.isEmpty())
    }

    @Test
    fun loadData_emptyListFromRepository() = runBlocking {
        whenever(shopRepository.getShopList()).thenReturn(
            ResponseBase(value = ArrayList(), errors = null, success = true)
        )

        viewModel.loadData()

        Assert.assertTrue(viewModel.shops.isEmpty())
    }

    @Test
    fun loadData_overwritesPreviousData() = runBlocking {
        whenever(shopRepository.getShopList()).thenReturn(
            ResponseBase(value = ArrayList(listOf(Shop("First"))), errors = null, success = true)
        )
        viewModel.loadData()

        whenever(shopRepository.getShopList()).thenReturn(
            ResponseBase(value = ArrayList(listOf(Shop("Second"))), errors = null, success = true)
        )
        viewModel.loadData()

        Assert.assertEquals(1, viewModel.shops.size)
        Assert.assertEquals("Second", viewModel.shops.first().name)
    }
}