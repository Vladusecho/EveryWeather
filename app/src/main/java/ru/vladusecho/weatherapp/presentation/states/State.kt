package ru.vladusecho.weatherapp.presentation.states

import ru.vladusecho.weatherapp.domain.entities.Weather

sealed class State {

    object Loading: State()
    data class Content(val receivedWeather: Weather): State()
}