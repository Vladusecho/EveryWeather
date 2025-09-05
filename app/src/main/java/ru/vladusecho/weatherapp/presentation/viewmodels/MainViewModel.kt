package ru.vladusecho.weatherapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.vladusecho.weatherapp.data.repository.WeatherRepositoryImpl
import ru.vladusecho.weatherapp.domain.entities.Weather

class MainViewModel : ViewModel() {

    val repository = WeatherRepositoryImpl

    private val _weatherLiveData = MutableLiveData<Weather>()
    val weatherLiveData: LiveData<Weather>
        get() = _weatherLiveData

    fun loadWeather(city: String) {
        viewModelScope.launch {
            _weatherLiveData.value = repository.getWeatherByCity(city)
        }
    }
}