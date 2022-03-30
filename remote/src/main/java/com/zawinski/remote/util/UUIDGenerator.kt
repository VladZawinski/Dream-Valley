package com.zawinski.remote.util

import java.util.*

object UUIDGenerator {
    fun generate() = UUID.randomUUID().toString()
}