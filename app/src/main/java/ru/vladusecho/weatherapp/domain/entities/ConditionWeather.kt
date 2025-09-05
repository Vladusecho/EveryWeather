package ru.vladusecho.weatherapp.domain.entities

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class ConditionWeather(

    @SerializedName("text") val text: String,
    @SerializedName("icon") val icon: String
)