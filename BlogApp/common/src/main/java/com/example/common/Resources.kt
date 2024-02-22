package com.example.common

sealed class Resources<T> (
    val data: T? = null,
    val message: String? = null
) {

    class Success<T>(data: T?): Resources<T>(data = data)

    class Error<T>(message: String?): Resources<T>()

    class Loading<T>(message: String?): Resources<T>(message = message)

}