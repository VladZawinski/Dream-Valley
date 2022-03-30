package com.zawinski.data.datasource.episode

import com.zawinski.data.model.episode.EpisodeDataModel

interface EpisodeRemoteDataSource {
    suspend fun getEpisodes(): List<EpisodeDataModel>
}