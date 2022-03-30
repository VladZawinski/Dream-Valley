package com.zawinski.remote.mappers

import com.zawinski.common.Mapper
import com.zawinski.data.model.art.CoverAsset
import com.zawinski.data.model.episode.EpisodeChannelDataModel
import com.zawinski.data.model.episode.EpisodeDataModel
import com.zawinski.remote.models.episode.EpisodeChannelRemoteModel

import com.zawinski.remote.models.episode.EpisodeRemoteModel
import javax.inject.Inject

class EpisodeRemoteMapper @Inject constructor(): Mapper<EpisodeRemoteModel, EpisodeDataModel> {
    override fun from(i: EpisodeRemoteModel?): EpisodeDataModel {
        return EpisodeDataModel(
            channel = EpisodeChannelDataModel(i?.channel?.title),
            coverAsset = CoverAsset(i?.coverAsset?.url!!),
            title = i.title,
            type = i.type
        )
    }

    override fun to(o: EpisodeDataModel?): EpisodeRemoteModel {
        return EpisodeRemoteModel(
            channel = EpisodeChannelRemoteModel(o?.channel?.title),
            coverAsset = com.zawinski.remote.models.art.CoverAsset(o?.coverAsset?.url),
            title = o?.title,
            type = o?.type
        )
    }
}