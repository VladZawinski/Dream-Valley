package com.zawinski.cache.dao

import androidx.room.Dao
import androidx.room.Query
import com.zawinski.cache.base.BaseDao
import com.zawinski.cache.entity.channel.SeriesEntity

@Dao
abstract class SeriesDao: BaseDao<SeriesEntity>() {
    @Query("DELETE FROM series")
    abstract suspend fun deleteAll()

    @Query("SELECT * FROM series WHERE channel_id = :key")
    abstract fun queryByForeignKey(key: String): List<SeriesEntity>
}