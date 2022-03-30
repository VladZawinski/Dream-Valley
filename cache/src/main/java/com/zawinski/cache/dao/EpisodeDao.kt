package com.zawinski.cache.dao

import androidx.room.Dao
import androidx.room.Query
import com.zawinski.cache.base.BaseDao
import com.zawinski.cache.entity.episode.EpisodeEntity

@Dao
abstract class EpisodeDao: BaseDao<EpisodeEntity>() {
    @Query("SELECT * FROM episode")
    abstract suspend fun findAll(): List<EpisodeEntity>

    @Query("DELETE FROM episode")
    abstract suspend fun deleteAll()
}