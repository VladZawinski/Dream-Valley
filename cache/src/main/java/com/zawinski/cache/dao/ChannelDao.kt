package com.zawinski.cache.dao

import androidx.room.Dao
import androidx.room.Query
import com.zawinski.cache.base.BaseDao
import com.zawinski.cache.entity.channel.ChannelEntity

@Dao
abstract class ChannelDao: BaseDao<ChannelEntity>() {
    @Query("SELECT * FROM channel LIMIT 1")
    abstract suspend fun findFirst(): ChannelEntity?

    @Query("SELECT * FROM channel")
    abstract suspend fun findAll(): List<ChannelEntity>

    @Query("DELETE FROM channel")
    abstract suspend fun deleteAll()
}