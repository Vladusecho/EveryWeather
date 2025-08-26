package ru.vladusecho.weatherapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import ru.vladusecho.weatherapp.data.repository.WeatherRepositoryImpl

class MainViewModel : ViewModel() {

    val repository = WeatherRepositoryImpl
}