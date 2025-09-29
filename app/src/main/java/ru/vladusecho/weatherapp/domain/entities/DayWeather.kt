package ru.vladusecho.weatherapp.domain.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
data class DayWeather(

    @SerializedName("date") val date: String,
    @SerializedName("condition") val describing: ConditionWeather,
    @SerializedName("hour") val dayWeather: ArrayList<HourWeather>
) : Parcelable