package com.zawinski.data.datasource.category

import com.zawinski.data.model.category.CategoryDataModel

interface CategoryRemoteDataSource {
    suspend fun getCategories(): List<CategoryDataModel>
}