package com.zawinski.data.repository

import com.zawinski.common.Resource
import com.zawinski.data.datasource.category.CategoryCacheDataSource
import com.zawinski.data.datasource.category.CategoryRemoteDataSource
import com.zawinski.data.mapper.CategoryDataMapper
import com.zawinski.domain.model.CategoryDomainModel
import com.zawinski.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

internal class CategoryRepositoryImpl @Inject constructor(
    private val categoryCacheDataSource: CategoryCacheDataSource,
    private val categoryRemoteDataSource: CategoryRemoteDataSource,
    private val mapper: CategoryDataMapper
): CategoryRepository {

    override suspend fun getCategories(): Flow<Resource<List<CategoryDomainModel>>> = flow {
        emitCache()
        emitRemote()
    }

    private suspend fun emitCache()
            = flow<Resource<List<CategoryDomainModel>>> { emit(Resource.Success(mapper.fromList(categoryCacheDataSource.findAll()))) }

    private suspend fun emitRemote() =
        flow<Resource<List<CategoryDomainModel>>> {
            runCatching {
                categoryRemoteDataSource.getCategories()
            }.onFailure {
                emit(Resource.Error(it as Exception))
            }.onSuccess {
                emit(Resource.Success(mapper.fromList(it)))
                categoryCacheDataSource.deleteAll()
                categoryCacheDataSource.upsertAll(it)
            }
        }

}