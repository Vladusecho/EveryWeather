package ru.vladusecho.weatherapp.presentation.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import coil.Coil
import coil.load
import ru.vladusecho.weatherapp.R
import ru.vladusecho.weatherapp.databinding.ActivityMainBinding
import ru.vladusecho.weatherapp.domain.entities.Weather
import ru.vladusecho.weatherapp.presentation.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        viewModel.weatherLiveData.observe(this) {
            binding.tvCurrentWeather.text = it.currentWeather.toString()
            binding.tvCurrentLocation.text = it.locationWeather.toString()
            binding.ivWeatherIcon.load("https:" + it.currentWeather.describing.icon) {
                crossfade(true)
            }
        }
        binding.btnSearch.setOnClickListener {
            viewModel.loadWeather(binding.etCityName.text.toString())
        }
    }
}