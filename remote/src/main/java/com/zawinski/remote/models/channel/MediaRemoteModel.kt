package com.zawinski.remote.models.channel

import com.zawinski.remote.models.art.CoverAsset

data class MediaRemoteModel(
    val type: String,
    val title: String,
    val coverAsset: CoverAsset
)