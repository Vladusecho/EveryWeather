package ru.vladusecho.weatherapp.domain.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeather(

    @SerialName("last_updated") val lastUpdate: String,
    @SerialName("temp_c") val temp: String,
    @SerialName("wind_kph") val wind: String,
    @SerialName("condition") val describing: ConditionWeather
)