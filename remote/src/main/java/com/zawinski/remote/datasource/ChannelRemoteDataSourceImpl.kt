package com.zawinski.remote.datasource

import com.zawinski.data.datasource.channel.ChannelRemoteDataSource
import com.zawinski.data.model.channel.ChannelDataModel
import com.zawinski.remote.api.PasteBinAPI
import com.zawinski.remote.mappers.ChannelRemoteMapper
import javax.inject.Inject

internal class ChannelRemoteDataSourceImpl @Inject constructor(
    private val api: PasteBinAPI,
    private val channelRemoteMapper: ChannelRemoteMapper
): ChannelRemoteDataSource {

    override suspend fun getChannels(): List<ChannelDataModel> =
        channelRemoteMapper.fromList(api.getChannels().data.channels)

}