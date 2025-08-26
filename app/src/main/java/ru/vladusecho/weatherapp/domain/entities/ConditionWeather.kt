package ru.vladusecho.weatherapp.domain.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConditionWeather(

    @SerialName("text") val text: String,
    @SerialName("icon") val icon: String
)