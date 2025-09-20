package ru.vladusecho.weatherapp.presentation.states

import ru.vladusecho.weatherapp.domain.entities.Weather

sealed class State {

    data class Error(val errorText: String): State()
    object Loading: State()
    data class Content(val receivedWeather: Weather): State()
}