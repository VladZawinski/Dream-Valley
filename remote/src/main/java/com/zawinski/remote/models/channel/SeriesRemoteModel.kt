package com.zawinski.remote.models.channel

import com.zawinski.remote.models.art.CoverAsset

data class SeriesRemoteModel(
    val title: String,
    val coverAsset: CoverAsset?
)