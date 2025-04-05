package com.example.mysystemtest.data.utils

sealed class ResponseResult<out T> {
    object Loading : ResponseResult<Nothing>()
    data class Success<out T>(val data: T) : ResponseResult<T>()
    data class Error(val message: String) : ResponseResult<Nothing>()
}