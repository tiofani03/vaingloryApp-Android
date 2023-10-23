package com.tiooooo.vaingloryapp.domain.model


data class Hero(
    val id: Int,
    val name: String,
    val image: String,
    val desc: String,
    val power: List<PowerStatus>,
    val role: String,
    val attackType: String,
    val position: String,
    val skills: List<SkillStatus>,
    val skins: List<SkinStatus>,
)


data class PowerStatus(
    val name: String,
    val currentValue: Int,
    val maxValue: Int,
)


data class SkillStatus(
    val skillName: String,
    val skillDesc: String,
    val skillImage: String,
)


data class SkinStatus(
    val skinName: String,
    val skinImage: String,
    val skinType: String = "Default"
)
