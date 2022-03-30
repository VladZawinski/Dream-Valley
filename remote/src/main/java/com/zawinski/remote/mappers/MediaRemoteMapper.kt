package com.zawinski.remote.mappers

import com.zawinski.common.Mapper
import com.zawinski.data.model.art.CoverAsset
import com.zawinski.data.model.channel.MediaDataModel
import com.zawinski.remote.models.channel.MediaRemoteModel
import javax.inject.Inject

class MediaRemoteMapper @Inject constructor(): Mapper<MediaRemoteModel, MediaDataModel> {
    override fun from(i: MediaRemoteModel?): MediaDataModel {
        return MediaDataModel(
            type = i?.type!!,
            title = i?.title,
            coverAsset = CoverAsset(i.coverAsset.url)
        )
    }

    override fun to(o: MediaDataModel?): MediaRemoteModel {
        return MediaRemoteModel(
            type = o?.type!!,
            title = o?.title,
            coverAsset = com.zawinski.remote.models.art.CoverAsset(o.coverAsset.url)
        )
    }
}