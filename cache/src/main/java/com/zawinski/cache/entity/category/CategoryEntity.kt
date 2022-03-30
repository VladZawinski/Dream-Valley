package com.zawinski.cache.entity.category

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zawinski.cache.base.BaseEntity

@Entity(
    tableName = "category"
)
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = -1L,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "expired_time_stamp")
    val expiredTimeStamp: Long
): BaseEntity