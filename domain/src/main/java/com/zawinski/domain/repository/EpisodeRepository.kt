package com.zawinski.domain.repository

import com.zawinski.common.Resource
import com.zawinski.domain.model.EpisodeDomainModel
import kotlinx.coroutines.flow.Flow

interface EpisodeRepository {
    suspend fun getNewEpisodes(): Flow<Resource<List<EpisodeDomainModel>>>
}