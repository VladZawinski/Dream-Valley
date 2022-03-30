package com.zawinski.data.repository

import com.zawinski.common.Resource
import com.zawinski.domain.model.CategoryDomainModel
import com.zawinski.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class CategoryRepositoryImpl @Inject constructor(

): CategoryRepository {

    override suspend fun getCategories(): Flow<Resource<List<CategoryDomainModel>>> = flow {

    }

}