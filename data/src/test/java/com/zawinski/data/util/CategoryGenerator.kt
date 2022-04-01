package com.zawinski.data.util

import com.zawinski.data.model.category.CategoryDataModel

object CategoryGenerator {
    fun generateCategories() = listOf(
        CategoryDataModel("One"),
        CategoryDataModel("Two"),
        CategoryDataModel("Three")
    )
}