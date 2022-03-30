package com.zawinski.data.datasource.channel

import com.zawinski.data.datasource.BaseCacheDataSource
import com.zawinski.data.model.channel.ChannelDataModel

interface ChannelCacheDataSource: BaseCacheDataSource<ChannelDataModel> {
    suspend fun findFirstOrNull(): ChannelDataModel?
}