package ru.vladusecho.weatherapp.data.repository

import ru.vladusecho.weatherapp.data.remote.ApiFactory
import ru.vladusecho.weatherapp.domain.entities.Weather

object WeatherRepositoryImpl {

    private val apiService = ApiFactory.createWeatherApiService()

    suspend fun getWeatherByCity(city: String): Weather {
        return apiService.getCurrentWeather(city)
    }
}