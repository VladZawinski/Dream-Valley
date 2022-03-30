package com.zawinski.domain.model

data class ChannelDomainModel(
    val iconAssetUrl: String,
    val series: List<SeriesDomainModel>?,
    val latestMedias: List<MediaDomainModel>,
    val type: String,
    val mediaCount: Int?,
    val title: String?
)