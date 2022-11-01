package com.rizkir.androiddevtest.common

/**
 * created by RIZKI RACHMANUDIN on 30/10/2022
 */
sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(var isLoading: Boolean = true, data: T? = null) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
}
