package com.zawinski.remote.datasource

import com.zawinski.common.Mapper
import com.zawinski.data.datasource.category.CategoryRemoteDataSource
import com.zawinski.data.model.category.CategoryDataModel
import com.zawinski.remote.api.PasteBinAPI
import com.zawinski.remote.models.category.CategoryRemoteModel
import javax.inject.Inject

class CategoryRemoteDataSourceImpl @Inject constructor(
    private val api: PasteBinAPI,
    private val mapper: Mapper<CategoryRemoteModel, CategoryDataModel>
): CategoryRemoteDataSource {

    override suspend fun getCategories(): List<CategoryDataModel> {
        return mapper.fromList(api.getCategories().data.categories)
    }

}