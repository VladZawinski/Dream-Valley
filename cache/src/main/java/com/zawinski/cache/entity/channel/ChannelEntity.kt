package com.zawinski.cache.entity.channel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.zawinski.cache.base.BaseEntity

@Entity(
    tableName = "channel"
)
data class ChannelEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String?,
    @ColumnInfo(name = "title")
    val title: String?,
    @ColumnInfo(name = "cover_url")
    val coverUrl: String?,
    @ColumnInfo(name = "thumbnail_url")
    val thumbnailUrl: String?,
    @ColumnInfo(name = "media_count")
    val mediaCount: Int?,
    @Ignore
    val series: List<SeriesEntity> = emptyList(),
    @Ignore
    val latestMedia: List<MediaEntity> = emptyList(),
): BaseEntity