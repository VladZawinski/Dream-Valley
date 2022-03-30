package com.zawinski.remote.mappers

import com.zawinski.common.Mapper
import com.zawinski.data.model.category.CategoryDataModel
import com.zawinski.remote.models.category.CategoryRemoteModel
import javax.inject.Inject

class CategoryRemoteMapper @Inject constructor(): Mapper<CategoryRemoteModel, CategoryDataModel> {
    override fun from(i: CategoryRemoteModel?): CategoryDataModel {
        return CategoryDataModel(i?.name!!)
    }

    override fun to(o: CategoryDataModel?): CategoryRemoteModel {
        return CategoryRemoteModel(o?.name!!)
    }
}