package com.tiooooo.vaingloryapp.utils.response

sealed class States<T>(
    val data: T? = null,
    val message: String? = null,
    val statusCode: Int? = null
) {
    class Success<T>(data: T) : States<T>(data)
    class Loading<T>(data: T? = null) : States<T>(data)
    class Error<T>(message: String, data: T? = null, statusCode: Int? = null) :
        States<T>(data, message, statusCode)
}


sealed class BaseResult<out T : Any, out U : Any> {
    class Success<T : Any>(val data: T) : BaseResult<T, Nothing>()
    class Error<U : Any>(val rawResponse: U) : BaseResult<Nothing, U>()
}
