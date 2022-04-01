package com.zawinski.data.repository

import app.cash.turbine.test
import com.zawinski.data.datasource.category.CategoryCacheDataSource
import com.zawinski.data.datasource.category.CategoryRemoteDataSource
import com.zawinski.data.mapper.CategoryDataMapper
import com.zawinski.data.model.category.CategoryDataModel
import com.zawinski.data.util.CategoryGenerator
import com.zawinski.domain.repository.CategoryRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class CategoryRepositoryImplTest {

    @MockK
    private lateinit var localDataSource: CategoryCacheDataSource
    @MockK
    private lateinit var remoteDataSource: CategoryRemoteDataSource

    private lateinit var repository: CategoryRepository
    private val categoryMapper = CategoryDataMapper()

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        repository = CategoryRepositoryImpl(localDataSource,remoteDataSource,categoryMapper)
    }

    @Test
    fun `testFirstTimeFetch`() = runBlocking {
        val cache = emptyList<CategoryDataModel>()
        val remote = CategoryGenerator.generateCategories()

        // Given
        coEvery { localDataSource.findAll() } returns cache
        coEvery { remoteDataSource.getCategories() } returns remote

        val flow = repository.getCategories()
        flow.test {

        }

    }






}