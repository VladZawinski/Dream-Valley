package com.zawinski.remote.response

import com.zawinski.remote.models.category.CategoryRemoteModel

data class CategoryNode(
    val categories: List<CategoryRemoteModel>
)