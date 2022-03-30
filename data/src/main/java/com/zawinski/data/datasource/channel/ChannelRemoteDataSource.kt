package com.zawinski.data.datasource.channel

import com.zawinski.data.model.channel.ChannelDataModel

interface ChannelRemoteDataSource {
    suspend fun getChannels(): List<ChannelDataModel>
}