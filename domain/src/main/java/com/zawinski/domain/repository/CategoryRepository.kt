package com.zawinski.domain.repository

import com.zawinski.common.Resource
import com.zawinski.domain.model.CategoryDomainModel
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    suspend fun getCategories(): Flow<Resource<List<CategoryDomainModel>>>
}