package com.zawinski.remote.mappers

import com.zawinski.common.Mapper
import com.zawinski.data.model.art.CoverAsset
import com.zawinski.data.model.art.IconAsset
import com.zawinski.data.model.channel.ChannelDataModel
import com.zawinski.remote.models.channel.ChannelRemoteModel
import com.zawinski.remote.util.UUIDGenerator
import javax.inject.Inject

class ChannelRemoteMapper @Inject constructor(
    private val seriesRemoteMapper: SeriesRemoteMapper,
    private val mediaRemoteMapper: MediaRemoteMapper
): Mapper<ChannelRemoteModel, ChannelDataModel> {

    override fun from(i: ChannelRemoteModel?): ChannelDataModel {
        return ChannelDataModel(
            coverAsset = CoverAsset(i?.coverAsset?.url),
            iconAsset = IconAsset(i?.iconAsset?.thumbnailUrl),
            id = i?.id ?: UUIDGenerator.generate(),
            latestMedia = mediaRemoteMapper.fromList(i?.latestMedia),
            series = seriesRemoteMapper.fromList(i?.series),
            mediaCount = i?.mediaCount,
            title = i?.title
        )
    }

    override fun to(o: ChannelDataModel?): ChannelRemoteModel {
        return ChannelRemoteModel(
            coverAsset = com.zawinski.remote.models.art.CoverAsset(o?.coverAsset?.url),
            iconAsset = com.zawinski.remote.models.art.IconAsset(o?.iconAsset?.thumbnailUrl),
            id = o?.id,
            latestMedia = mediaRemoteMapper.toList(o?.latestMedia),
            series = seriesRemoteMapper.toList(o?.series),
            mediaCount = o?.mediaCount,
            title = o?.title
        )
    }
}