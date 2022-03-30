package com.zawinski.cache.source

import com.zawinski.cache.dao.CategoryDao
import com.zawinski.cache.entity.category.CategoryEntity
import com.zawinski.common.Mapper
import com.zawinski.data.datasource.category.CategoryCacheDataSource
import com.zawinski.data.model.category.CategoryDataModel
import javax.inject.Inject

internal class CategoryCacheDataSourceImpl @Inject constructor(
    private val dao: CategoryDao,
    private val categoryMapper: Mapper<CategoryEntity, CategoryDataModel>
): CategoryCacheDataSource {

    override suspend fun findAll(): List<CategoryDataModel> =
        categoryMapper.fromList(dao.getAll())


    override suspend fun deleteAll() {
        dao.deleteAll()
    }

    override suspend fun upsertOne(one: CategoryDataModel) {
        dao.insert(categoryMapper.to(one))
    }

    override suspend fun upsertAll(list: List<CategoryDataModel>) {
        dao.insertAll(categoryMapper.toList(list))
    }
}