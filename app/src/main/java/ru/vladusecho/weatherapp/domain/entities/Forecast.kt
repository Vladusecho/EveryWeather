package ru.vladusecho.weatherapp.domain.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Forecast(

    @SerialName("forecastday") val forecastDay: List<DayWeather>
)
