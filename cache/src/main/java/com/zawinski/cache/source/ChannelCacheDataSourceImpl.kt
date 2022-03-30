package com.zawinski.cache.source

import com.zawinski.cache.dao.ChannelDao
import com.zawinski.cache.dao.MediaDao
import com.zawinski.cache.dao.SeriesDao
import com.zawinski.cache.mapper.ChannelCacheMapper
import com.zawinski.cache.mapper.MediaCacheMapper
import com.zawinski.cache.mapper.SeriesCacheMapper
import com.zawinski.data.datasource.channel.ChannelCacheDataSource
import com.zawinski.data.model.channel.ChannelDataModel
import javax.inject.Inject

class ChannelCacheDataSourceImpl @Inject constructor(
    private val dao: ChannelDao,
    private val mapper: ChannelCacheMapper,
    private val mediaMapper: MediaCacheMapper,
    private val seriesMapper: SeriesCacheMapper,
    private val mediaDao: MediaDao,
    private val seriesDao: SeriesDao,
): ChannelCacheDataSource {

    override suspend fun findFirstOrNull(): ChannelDataModel? {
        val firstOrNull = dao.findFirst()

        return if (firstOrNull == null) {
            null
        } else {
            val series = seriesDao.queryByForeignKey(firstOrNull.id!!)
            val media = mediaDao.queryByForeignKey(firstOrNull.id!!)

            mapper.from(dao.findFirst(), media, series)
        }
    }

    override suspend fun findAll(): List<ChannelDataModel> {
        return dao.findAll().map {
            mapper.from(it, mediaDao.queryByForeignKey(it.id!!), seriesDao.queryByForeignKey(it.id))
        }
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
        seriesDao.deleteAll()
        mediaDao.deleteAll()
    }

    override suspend fun upsertOne(one: ChannelDataModel) {
        dao.insert(mapper.to(one))
        mediaDao.insertAll(mediaMapper.toList(one.latestMedia, one.id!!))
        seriesDao.insertAll(seriesMapper.toList(one.series, one.id!!))
    }

    override suspend fun upsertAll(list: List<ChannelDataModel>) {
        list.forEach {
            upsertOne(it)
        }
    }

}