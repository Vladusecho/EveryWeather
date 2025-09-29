package ru.vladusecho.weatherapp.domain.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
data class HourWeather(

    @SerializedName("time") val time: String,
    @SerializedName("temp_c") val temp: String,
    @SerializedName("wind_kph") val wind: String,
    @SerializedName("chance_of_rain") val chanceRain: String,
    @SerializedName("chance_of_snow") val chanceSnow: String,
    @SerializedName("condition") val describing: ConditionWeather
) : Parcelable