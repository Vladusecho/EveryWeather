package ru.vladusecho.weatherapp.domain.repository

import ru.vladusecho.weatherapp.domain.entities.Weather

interface WeatherRepository {

    fun getCityWeather(): Weather
}