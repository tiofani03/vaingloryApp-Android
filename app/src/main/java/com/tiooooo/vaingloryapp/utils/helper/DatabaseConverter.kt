package com.tiooooo.vaingloryapp.utils.helper

import androidx.room.TypeConverter
import com.tiooooo.vaingloryapp.data.model.PowerStatus
import com.tiooooo.vaingloryapp.data.model.SkillStatus
import com.tiooooo.vaingloryapp.data.model.SkinStatus
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class DatabaseConverter {
    private val json = Json { ignoreUnknownKeys = true }

    @TypeConverter
    fun fromPowerStatusList(value: List<PowerStatus>): String {
        return json.encodeToString(value)
    }

    @TypeConverter
    fun toPowerStatusList(value: String): List<PowerStatus> {
        return json.decodeFromString(value)
    }

    @TypeConverter
    fun fromSkillStatusList(value: List<SkillStatus>): String {
        return json.encodeToString(value)
    }

    @TypeConverter
    fun toSkillStatusList(value: String): List<SkillStatus> {
        return json.decodeFromString(value)
    }

    @TypeConverter
    fun fromSkinStatusList(value: List<SkinStatus>): String {
        return json.encodeToString(value)
    }

    @TypeConverter
    fun toSkinStatusList(value: String): List<SkinStatus> {
        return json.decodeFromString(value)
    }
}
