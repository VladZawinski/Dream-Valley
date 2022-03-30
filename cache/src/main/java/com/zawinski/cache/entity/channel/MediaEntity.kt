package com.zawinski.cache.entity.channel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.zawinski.cache.base.BaseEntity

@Entity(
    tableName = "media"
)
data class MediaEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = -1L,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "cover_url")
    val coverUrl: String,
    @ColumnInfo(name = "channel_id")
    val channelId: String
): BaseEntity