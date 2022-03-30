package com.zawinski.data.model.channel

import com.zawinski.data.model.art.CoverAsset

data class MediaDataModel(
    val type: String,
    val title: String,
    val coverAsset: CoverAsset
)