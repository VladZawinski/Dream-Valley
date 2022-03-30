package com.zawinski.remote.models.episode

import com.zawinski.remote.models.art.CoverAsset

data class EpisodeRemoteModel(
    val channel: EpisodeChannelRemoteModel?,
    val coverAsset: CoverAsset?,
    val title: String?,
    val type: String?
)