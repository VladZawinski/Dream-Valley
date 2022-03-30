package com.zawinski.remote.datasource

import com.zawinski.data.datasource.episode.EpisodeRemoteDataSource
import com.zawinski.data.model.episode.EpisodeDataModel
import com.zawinski.remote.api.PasteBinAPI
import com.zawinski.remote.mappers.EpisodeRemoteMapper
import javax.inject.Inject

class EpisodeRemoteDataSourceImpl @Inject constructor(
    private val api: PasteBinAPI,
    private val episodeRemoteMapper: EpisodeRemoteMapper
): EpisodeRemoteDataSource {

    override suspend fun getEpisodes(): List<EpisodeDataModel> {
        return episodeRemoteMapper.fromList(api.getNewEpisodes().data.media)
    }

}