package com.zawinski.data.mapper

import com.zawinski.common.Mapper
import com.zawinski.data.model.category.CategoryDataModel
import com.zawinski.domain.model.CategoryDomainModel
import javax.inject.Inject

class CategoryDataMapper @Inject constructor(): Mapper<CategoryDataModel, CategoryDomainModel> {

    override fun from(i: CategoryDataModel?): CategoryDomainModel {
       return CategoryDomainModel(i?.name!!)
    }

    override fun to(o: CategoryDomainModel?): CategoryDataModel {
        return CategoryDataModel(o?.name!!)
    }
}