package com.zawinski.remote.models.channel

import com.zawinski.remote.models.art.CoverAsset
import com.zawinski.remote.models.art.IconAsset

data class ChannelRemoteModel(
    val coverAsset: CoverAsset?,
    val iconAsset: IconAsset?,
    val id: String?,
    val latestMedia: List<MediaRemoteModel>?,
    val mediaCount: Int?,
    val series: List<SeriesRemoteModel>?,
    val title: String?
)