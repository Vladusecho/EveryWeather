package ru.vladusecho.weatherapp.domain.entities

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class Forecast(

    @SerializedName("forecastday") val forecastDay: List<DayWeather>
)
