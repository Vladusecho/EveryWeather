package ru.vladusecho.weatherapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.vladusecho.weatherapp.data.repository.WeatherRepositoryImpl
import ru.vladusecho.weatherapp.domain.entities.Weather
import ru.vladusecho.weatherapp.presentation.states.State

class MainViewModel : ViewModel() {

    val repository = WeatherRepositoryImpl

//    private val _weatherLiveData = MutableLiveData<Weather>()
//    val weatherLiveData: LiveData<Weather>
//        get() = _weatherLiveData

    private val _stateLiveData = MutableLiveData<State>()
    val stateLiveData
        get() = _stateLiveData

    fun loadWeather(city: String) {
        viewModelScope.launch {
            _stateLiveData.value = State.Loading
            _stateLiveData.value = State.Content(repository.getWeatherByCity(city))
        }
    }
}