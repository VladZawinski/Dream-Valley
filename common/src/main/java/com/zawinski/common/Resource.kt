package com.zawinski.common

sealed class Resource<out T> {
    class Success<T>(val data: T) : Resource<T>()
    class Error(val exception : Exception) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
    object Empty : Resource<Nothing>()
    object Completed: Resource<Nothing>()
}