package com.tiooooo.vaingloryapp.utils.helper

import androidx.paging.LoadState
import java.net.ConnectException
import java.net.SocketTimeoutException

fun parseErrorMessage(error: LoadState.Error): String {
    return when (error.error) {
        is SocketTimeoutException -> "Server Unavailable"
        is ConnectException -> "No Internet Connection"
        else -> "Unknown Error"
    }
}
