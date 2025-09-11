package ru.vladusecho.weatherapp.presentation.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import coil.Coil
import coil.load
import ru.vladusecho.weatherapp.R
import ru.vladusecho.weatherapp.databinding.ActivityMainBinding
import ru.vladusecho.weatherapp.domain.entities.Weather
import ru.vladusecho.weatherapp.presentation.states.State
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
        viewModel.stateLiveData.observe(this) {
//            binding.tvCurrentWeather.text = it.currentWeather.toString()
//            binding.tvCurrentLocation.text = it.locationWeather.toString()
//            binding.ivWeatherIcon.load("https:" + it.currentWeather.describing.icon) {
//                crossfade(true)
//            }
            when(it) {
                is State.Loading -> {
                    with(binding) {
                        tvCurrentLocation.text = ""
                        tvCurrentWeather.text = ""
                        ivWeatherIcon.visibility = View.GONE
                        progressBar.visibility = View.VISIBLE
                    }

                }
                is State.Content -> {
                    with(binding) {
                        progressBar.visibility = View.GONE
                        tvCurrentWeather.text = it.receivedWeather.currentWeather.toString()
                        tvCurrentLocation.text = it.receivedWeather.locationWeather.toString()
                        ivWeatherIcon.visibility = View.VISIBLE
                        ivWeatherIcon.load("https:" + it.receivedWeather.currentWeather.describing.icon) {
                            crossfade(true)
                        }
                    }
                }
            }
        }
        binding.btnSearch.setOnClickListener {
            viewModel.loadWeather(binding.etCityName.text.toString())
        }
    }
}