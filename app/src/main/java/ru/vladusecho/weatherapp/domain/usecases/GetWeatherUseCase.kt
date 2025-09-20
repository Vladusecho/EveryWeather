package ru.vladusecho.weatherapp.domain.usecases

import ru.vladusecho.weatherapp.domain.repository.WeatherRepository

class GetWeatherUseCase(val repository: WeatherRepository) {

    operator fun invoke() {
        repository.getCityWeather()
    }
}