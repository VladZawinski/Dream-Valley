package com.zawinski.cache.mapper

import com.zawinski.cache.entity.channel.MediaEntity
import com.zawinski.common.ForeignMapper
import com.zawinski.data.model.art.CoverAsset
import com.zawinski.data.model.channel.MediaDataModel
import javax.inject.Inject

class MediaCacheMapper @Inject constructor(): ForeignMapper<MediaEntity, MediaDataModel> {
    override fun from(i: MediaEntity?): MediaDataModel {
        return MediaDataModel(
            type = i?.type!!,
            title = i.title,
            coverAsset = CoverAsset(i.coverUrl)
        )
    }

    override fun to(o: MediaDataModel?, foreignKey: String): MediaEntity {
        return MediaEntity(
            type = o?.type!!,
            title = o.title,
            coverUrl = o.coverAsset.url!!,
            channelId = foreignKey
        )
    }


}