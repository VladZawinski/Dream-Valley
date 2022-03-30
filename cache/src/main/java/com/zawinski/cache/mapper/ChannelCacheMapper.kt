package com.zawinski.cache.mapper

import com.zawinski.cache.dao.ChannelDao
import com.zawinski.cache.entity.channel.ChannelEntity
import com.zawinski.cache.entity.channel.MediaEntity
import com.zawinski.cache.entity.channel.SeriesEntity
import com.zawinski.data.model.art.CoverAsset
import com.zawinski.data.model.art.IconAsset
import com.zawinski.data.model.channel.ChannelDataModel
import com.zawinski.data.model.channel.MediaDataModel
import com.zawinski.data.model.channel.SeriesDataModel
import javax.inject.Inject

class ChannelCacheMapper @Inject constructor(
    private val mediaCacheMapper: MediaCacheMapper,
    private val seriesCacheMapper: SeriesCacheMapper
) {

    fun from(i: ChannelEntity?, media: List<MediaEntity>, series: List<SeriesEntity>): ChannelDataModel {
        return ChannelDataModel(
            id = i?.id,
            coverAsset = CoverAsset(i?.coverUrl),
            iconAsset = IconAsset(i?.thumbnailUrl),
            mediaCount = i?.mediaCount,
            title = i?.title,
            latestMedia = mediaCacheMapper.fromList(media),
            series = seriesCacheMapper.fromList(series)
        )
    }

    fun to(o: ChannelDataModel?): ChannelEntity {
        return ChannelEntity(
            id = o?.id,
            coverUrl = o?.coverAsset?.url,
            thumbnailUrl = o?.iconAsset?.thumbnailUrl,
            mediaCount = o?.mediaCount,
            title = o?.title
        )
    }

}