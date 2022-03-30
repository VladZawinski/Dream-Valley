package com.zawinski.cache.base

interface CacheRule {
    fun isExpired(validTimeStamp: Long)
    fun generateExpectedTimeStamp(): Long
}