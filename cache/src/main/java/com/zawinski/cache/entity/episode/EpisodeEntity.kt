package com.zawinski.cache.entity.episode

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zawinski.cache.base.BaseEntity

@Entity(
    tableName = "episode"
)
data class EpisodeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = -1L,
    @ColumnInfo(name = "channel_name")
    val channelName: String?,
    @ColumnInfo(name = "cover_url")
    val coverUrl: String?,
    @ColumnInfo(name = "title")
    val title: String?,
    @ColumnInfo(name = "type")
    val type: String?
): BaseEntity