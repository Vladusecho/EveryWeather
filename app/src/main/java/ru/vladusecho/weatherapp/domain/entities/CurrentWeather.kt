package ru.vladusecho.weatherapp.domain.entities

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class CurrentWeather(

    @SerializedName("last_updated") val lastUpdate: String,
    @SerializedName("temp_c") val temp: String,
    @SerializedName("wind_kph") val wind: String,
    @SerializedName("condition") val describing: ConditionWeather
)