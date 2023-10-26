package com.tiooooo.vaingloryapp.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

fun Color.toHex(): String {
    return String.format("#%06X", (this.toArgb() and 0xFFFFFF))
}
