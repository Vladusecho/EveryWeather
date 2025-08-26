package ru.vladusecho.weatherapp.domain.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DayWeather(

    @SerialName("date") val date: String,
    @SerialName("condition") val describing: ConditionWeather,
    @SerialName("hour") val dayWeather: List<HourWeather>
)