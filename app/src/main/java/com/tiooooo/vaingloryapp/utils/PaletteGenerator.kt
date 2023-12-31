package com.tiooooo.vaingloryapp.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.palette.graphics.Palette
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult

object PaletteGenerator {

    suspend fun convertImageUrlToBitmap(
        imageUrl: String,
        context: Context,
    ): Bitmap? {
        val loader = ImageLoader(context = context)
        val request =
            ImageRequest.Builder(context = context).data(imageUrl).allowHardware(false).build()
        val imageResult = loader.execute(request)

        return if (imageResult is SuccessResult) {
            (imageResult.drawable as BitmapDrawable).bitmap
        } else {
            null
        }
    }

    fun extractColorFromBitmap(bitmap: Bitmap): Map<String, String> {
        return mapOf(
            "vibrant" to parseColorSwatch(Palette.from(bitmap).generate().vibrantSwatch),
            "darkVibrant" to parseColorSwatch(Palette.from(bitmap).generate().darkVibrantSwatch),
            "onDarkVibrant" to parseBodyColor(
                Palette.from(bitmap).generate().darkVibrantSwatch?.bodyTextColor
            )
        )
    }

    private fun parseColorSwatch(color: Palette.Swatch?) = if (color != null) {
        val parsedColor = Integer.toHexString(color.rgb)
        "#$parsedColor"
    } else "#1e1e1e"

    private fun parseBodyColor(color: Int?): String = if (color != null) {
        val parsedColor = Integer.toHexString(color)
        "#$parsedColor"
    } else "#FFFFFF"
}
