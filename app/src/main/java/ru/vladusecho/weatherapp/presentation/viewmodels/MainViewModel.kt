package ru.vladusecho.weatherapp.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.HttpException
import ru.vladusecho.weatherapp.data.repository.WeatherRepositoryImpl
import ru.vladusecho.weatherapp.presentation.states.State

class MainViewModel : ViewModel() {

    val repository = WeatherRepositoryImpl
    private val _stateLiveData = MutableLiveData<State>()
    val stateLiveData
        get() = _stateLiveData

    fun loadWeather(city: String) {
        viewModelScope.launch {
            _stateLiveData.value = State.Loading
            try {
                _stateLiveData.value = State.Content(repository.getWeatherByCity(city))
            } catch (e: HttpException) {
                _stateLiveData.value = State.Error(SEARCHING_ERROR)
            } catch (e: Exception) {
                _stateLiveData.value = State.Error(UNKNOWN_ERROR)
            }
        }
    }

    companion object {
        const val UNKNOWN_ERROR = "Произошла неопознанная ошибка."
        const val SEARCHING_ERROR = "Неверный запрос, попробуйте снова..."
    }
}