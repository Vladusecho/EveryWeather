package ru.vladusecho.weatherapp.domain.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HourWeather(

    @SerialName("time") val time: String,
    @SerialName("temp_c") val temp: String,
    @SerialName("wind_kph") val wind: String,
    @SerialName("chance_of_rain") val chanceRain: String,
    @SerialName("chance_of_snow") val chanceSnow: String,
    @SerialName("condition") val describing: ConditionWeather
)