package com.zawinski.cache.dao

import androidx.room.Dao
import androidx.room.Query
import com.zawinski.cache.base.BaseDao
import com.zawinski.cache.entity.category.CategoryEntity

@Dao
abstract class CategoryDao: BaseDao<CategoryEntity>() {
    @Query("SELECT * FROM category")
    abstract suspend fun getAll(): List<CategoryEntity>

    @Query("DELETE FROM category")
    abstract suspend fun deleteAll()
}