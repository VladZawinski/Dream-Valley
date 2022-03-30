package com.zawinski.cache.mapper

import com.zawinski.cache.entity.channel.SeriesEntity
import com.zawinski.common.ForeignMapper
import com.zawinski.data.model.art.CoverAsset
import com.zawinski.data.model.channel.SeriesDataModel
import javax.inject.Inject

class SeriesCacheMapper @Inject constructor(): ForeignMapper<SeriesEntity, SeriesDataModel> {

    override fun from(i: SeriesEntity?): SeriesDataModel {
        return SeriesDataModel(
            title = i?.title!!,
            coverAsset = CoverAsset(i.coverUrl)
        )
    }

    override fun to(o: SeriesDataModel?, foreignKey: String): SeriesEntity {
        return SeriesEntity(
            title = o?.title!!,
            coverUrl = o.coverAsset?.url ?: "",
            channelId = foreignKey
        )
    }

}