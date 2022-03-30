package com.zawinski.remote.mappers

import com.zawinski.common.Mapper
import com.zawinski.data.model.art.CoverAsset
import com.zawinski.data.model.channel.SeriesDataModel
import com.zawinski.remote.models.channel.SeriesRemoteModel
import javax.inject.Inject

class SeriesRemoteMapper @Inject constructor(): Mapper<SeriesRemoteModel, SeriesDataModel> {
    override fun from(i: SeriesRemoteModel?): SeriesDataModel {
        return SeriesDataModel(
            title = i?.title!!,
            coverAsset = CoverAsset(i?.coverAsset?.url)
        )
    }

    override fun to(o: SeriesDataModel?): SeriesRemoteModel {
        return SeriesRemoteModel(
            title = o?.title!!,
            coverAsset = com.zawinski.remote.models.art.CoverAsset(o?.coverAsset?.url)
        )
    }
}