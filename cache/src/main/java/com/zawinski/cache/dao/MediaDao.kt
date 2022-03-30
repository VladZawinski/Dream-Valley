package com.zawinski.cache.dao

import androidx.room.Dao
import androidx.room.Query
import com.zawinski.cache.base.BaseDao
import com.zawinski.cache.entity.channel.MediaEntity

@Dao
abstract class MediaDao: BaseDao<MediaEntity>() {
    @Query("DELETE FROM media")
    abstract suspend fun deleteAll()

    @Query("SELECT * FROM media WHERE channel_id = :key")
    abstract suspend fun queryByForeignKey(key: String): List<MediaEntity>
}