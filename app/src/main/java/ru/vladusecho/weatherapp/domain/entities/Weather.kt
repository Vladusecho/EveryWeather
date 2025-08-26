package ru.vladusecho.weatherapp.domain.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Weather(

    @SerialName("current") val currentWeather: CurrentWeather,
    @SerialName("location") val locationWeather: LocationWeather,
    @SerialName("forecast") val forecast: Forecast
)