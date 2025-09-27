package ru.vladusecho.weatherapp.domain.entities

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class CurrentWeather(

    @SerializedName("last_updated") val lastUpdate: String,
    @SerializedName("temp_c") val temp: String,
    @SerializedName("wind_kph") val wind: String,
    @SerializedName("condition") val describing: ConditionWeather
) {

    override fun toString(): String {
        return "Последнее обновление: $lastUpdate\n" +
                "Текущая температура: $temp °C\n" +
                "Скорость ветра: ${"%.1f".format(wind.toFloat()/3.6)} м/с\n" +
                "Погода: ${describing.text}"
    }

    fun getDateAsText(): String {
        return "Актуально на $lastUpdate\n(указано местное время)"
    }

    fun getWindAsText(): String {
        return "Ветер: ${"%.1f".format(wind.toFloat()/3.6)} м/с"
    }

    fun getTempAsText(): String {
        return "$temp °C"
    }
}