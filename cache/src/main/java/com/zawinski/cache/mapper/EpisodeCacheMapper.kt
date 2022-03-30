package com.zawinski.cache.mapper

import com.zawinski.cache.entity.episode.EpisodeEntity
import com.zawinski.common.Mapper
import com.zawinski.data.model.art.CoverAsset
import com.zawinski.data.model.episode.EpisodeChannelDataModel
import com.zawinski.data.model.episode.EpisodeDataModel
import javax.inject.Inject

class EpisodeCacheMapper @Inject constructor(): Mapper<EpisodeEntity, EpisodeDataModel> {
    override fun from(i: EpisodeEntity?): EpisodeDataModel {
        return EpisodeDataModel(
            channel = EpisodeChannelDataModel(title = i?.channelName),
            coverAsset = CoverAsset(url = i?.coverUrl),
            title = i?.title,
            type = i?.type
        )
    }

    override fun to(o: EpisodeDataModel?): EpisodeEntity {
        return EpisodeEntity(
            channelName = o?.channel?.title,
            coverUrl = o?.coverAsset?.url,
            title = o?.title,
            type = o?.type
        )
    }
}