package ru.vladusecho.weatherapp.domain.entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
data class ConditionWeather(

    @SerializedName("text") val text: String,
    @SerializedName("icon") val icon: String
) : Parcelable