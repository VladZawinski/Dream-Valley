package com.zawinski.domain.repository

import com.zawinski.common.Resource
import com.zawinski.domain.model.ChannelDomainModel
import kotlinx.coroutines.flow.Flow

interface ChannelRepository {
    suspend fun getChannels(): Flow<Resource<List<ChannelDomainModel>>>
}