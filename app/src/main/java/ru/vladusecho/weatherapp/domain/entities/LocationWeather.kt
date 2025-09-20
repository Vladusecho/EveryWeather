package ru.vladusecho.weatherapp.domain.entities

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class LocationWeather(

    @SerializedName("name") val locationName: String,
    @SerializedName("region") val region: String,
    @SerializedName("country") val country: String

) {

    override fun toString(): String {
        return "$locationName, $country"
    }
}