package com.zawinski.data.datasource

interface BaseCacheDataSource <T> {
    suspend fun findAll(): List<T>
    suspend fun deleteAll()
    suspend fun upsertOne(one: T)
    suspend fun upsertAll(list: List<T>)
}