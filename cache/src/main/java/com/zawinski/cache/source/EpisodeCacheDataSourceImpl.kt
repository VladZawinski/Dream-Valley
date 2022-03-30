package com.zawinski.cache.source

import com.zawinski.cache.dao.EpisodeDao
import com.zawinski.cache.mapper.EpisodeCacheMapper
import com.zawinski.data.datasource.episode.EpisodeCacheDataSource
import com.zawinski.data.model.episode.EpisodeDataModel
import javax.inject.Inject

class EpisodeCacheDataSourceImpl @Inject constructor(
    private val dao: EpisodeDao,
    private val episodeCacheMapper: EpisodeCacheMapper
): EpisodeCacheDataSource {

    override suspend fun findAll(): List<EpisodeDataModel> =
        episodeCacheMapper.fromList(dao.findAll())

    override suspend fun deleteAll() =
        dao.deleteAll()

    override suspend fun upsertOne(one: EpisodeDataModel) {
        dao.insert(episodeCacheMapper.to(one))
    }

    override suspend fun upsertAll(list: List<EpisodeDataModel>) {
        dao.insertAll(episodeCacheMapper.toList(list))
    }

}