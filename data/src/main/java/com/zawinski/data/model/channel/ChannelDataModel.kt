package com.zawinski.data.model.channel

import com.zawinski.data.model.art.CoverAsset
import com.zawinski.data.model.art.IconAsset

data class ChannelDataModel(
    val coverAsset: CoverAsset?,
    val iconAsset: IconAsset?,
    val id: String?,
    val latestMedia: List<MediaDataModel>?,
    val mediaCount: Int?,
    val series: List<SeriesDataModel>?,
    val title: String?
)