package ru.vladusecho.weatherapp.domain.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocationWeather(

    @SerialName("name") val locationName: String,
    @SerialName("region") val region: String,
    @SerialName("country") val country: String

)