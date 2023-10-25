package com.tiooooo.vaingloryapp.ui.screen.welcome

import androidx.annotation.RawRes
import com.tiooooo.vaingloryapp.R

sealed class OnBoardingPage(
    @RawRes val image: Int,
    val title: String,
    val description: String,
) {
    object First : OnBoardingPage(
        image = R.raw.lottie_hello,
        title = "Welcome to Vainglory App",
        description = "Vainglory App is an application that contains information about the characters in the Vainglory Game"
    )

    object Second : OnBoardingPage(
        image = R.raw.lottie_explore,
        title = "Explore",
        description = "Explore a vast array of diverse and captivating characters, and uncover the heroes inhabiting the rich and immersive universe of Vainglory."
    )

    object Third : OnBoardingPage(
        image = R.raw.lottie_power,
        title = "Power",
        description = "Discover detailed statistics and information for every character and hero featured in the immersive world of Vainglory. Explore their unique strengths and abilities."
    )
}

