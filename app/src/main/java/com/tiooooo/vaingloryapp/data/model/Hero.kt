package com.tiooooo.vaingloryapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tiooooo.vaingloryapp.utils.Constants.HERO_DATABASE_TABLE
import kotlinx.serialization.Serializable


@Serializable
@Entity(tableName = HERO_DATABASE_TABLE)
data class Hero(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val image: String,
    val imageBackground: String,
    val desc: String,
    val power: List<PowerStatus>,
    val role: String,
    val attackType: String,
    val position: String,
    val skills: List<SkillStatus>,
    val skins: List<SkinStatus>,
)

@Serializable
data class PowerStatus(
    val name: String,
    val currentValue: Int,
    val maxValue: Int,
)

@Serializable
data class SkillStatus(
    val skillName: String,
    val skillDesc: String,
    val skillImage: String,
)

@Serializable
data class SkinStatus(
    val skinName: String,
    val skinImage: String,
    val skinType: String = "Default"
)
