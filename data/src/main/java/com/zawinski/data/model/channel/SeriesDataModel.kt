package com.zawinski.data.model.channel

import com.zawinski.data.model.art.CoverAsset

data class SeriesDataModel(
    val title: String,
    val coverAsset: CoverAsset?
)