package com.zawinski.cache.util

import org.threeten.bp.*

object CacheTimeGenerator {
    /**
     * +30 seconds
     */
    fun generateStandardTime() = Duration.ofSeconds(30).toMillis() + Instant.now().toEpochMilli()
}