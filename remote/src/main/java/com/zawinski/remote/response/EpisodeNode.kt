package com.zawinski.remote.response

import com.zawinski.remote.models.episode.EpisodeRemoteModel

data class EpisodeNode(
    val media: List<EpisodeRemoteModel>
)