package com.zawinski.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zawinski.cache.dao.*
import com.zawinski.cache.entity.category.CategoryEntity
import com.zawinski.cache.entity.channel.ChannelEntity
import com.zawinski.cache.entity.channel.MediaEntity
import com.zawinski.cache.entity.channel.SeriesEntity
import com.zawinski.cache.entity.episode.EpisodeEntity

@Database(
    entities = [
        CategoryEntity::class,
        ChannelEntity::class,
        MediaEntity::class,
        SeriesEntity::class,
        EpisodeEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class DreamValleyDatabase: RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun channelDao(): ChannelDao
    abstract fun episodeDao(): EpisodeDao
    abstract fun mediaDao(): MediaDao
    abstract fun seriesDao(): SeriesDao
}