package ru.vladusecho.weatherapp.domain.entities

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class Weather(

    @SerializedName("current") val currentWeather: CurrentWeather,
    @SerializedName("location") val locationWeather: LocationWeather,
    @SerializedName("forecast") val forecast: Forecast
)