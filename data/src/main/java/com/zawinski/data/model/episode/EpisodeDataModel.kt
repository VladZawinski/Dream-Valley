package com.zawinski.data.model.episode

import com.zawinski.data.model.art.CoverAsset

data class EpisodeDataModel(
    val channel: EpisodeChannelDataModel?,
    val coverAsset: CoverAsset?,
    val title: String?,
    val type: String?
)

data class EpisodeChannelDataModel (
    val title: String?
)