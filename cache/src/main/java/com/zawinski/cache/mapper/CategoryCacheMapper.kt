package com.zawinski.cache.mapper

import com.zawinski.cache.entity.category.CategoryEntity
import com.zawinski.cache.util.CacheTimeGenerator
import com.zawinski.common.Mapper
import com.zawinski.data.model.category.CategoryDataModel
import javax.inject.Inject

class CategoryCacheMapper @Inject constructor(): Mapper<CategoryEntity, CategoryDataModel> {

    override fun from(i: CategoryEntity?): CategoryDataModel {
        return CategoryDataModel(name = i?.name!!)
    }

    override fun to(o: CategoryDataModel?): CategoryEntity {
        return CategoryEntity(name = o?.name!!, expiredTimeStamp = CacheTimeGenerator.generateStandardTime())
    }
}