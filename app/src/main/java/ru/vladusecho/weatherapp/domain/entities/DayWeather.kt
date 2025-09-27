package ru.vladusecho.weatherapp.domain.entities

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class DayWeather(

    @SerializedName("date") val date: String,
    @SerializedName("condition") val describing: ConditionWeather,
    @SerializedName("hour") val dayWeather: List<HourWeather>
)