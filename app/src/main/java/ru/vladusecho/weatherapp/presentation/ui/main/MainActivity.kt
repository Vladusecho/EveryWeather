package ru.vladusecho.weatherapp.presentation.ui.main

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.translationMatrix
import androidx.lifecycle.ViewModelProvider
import coil.load
import ru.vladusecho.weatherapp.R
import ru.vladusecho.weatherapp.databinding.ActivityMainBinding
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
        binding.upperSlider.startAnimation(
            AnimationUtils.loadAnimation(this, R.anim.slide_in_from_top)
        )
        binding.etCityName.startAnimation(
            AnimationUtils.loadAnimation(this, R.anim.slide_from_right)
        )
        binding.lowerSlider.startAnimation(
            AnimationUtils.loadAnimation(this, R.anim.slide_in_from_down)
        )
        binding.btnSearch.apply {
            translationX = 1000f
            alpha = 0f
            visibility = View.VISIBLE
            animate()
                .translationX(0f)
                .alpha(1f)
                .setDuration(1500)
                .withEndAction {
                    translationY = 0f
                    alpha = 1f
                }
                .start()
        }
        viewModel.stateLiveData.observe(this) {
            when(it) {
                is State.Loading -> {
                    with(binding) {
                        tvCurrentLocation.text = ""
                        tvCurrentWeather.text = ""
                        ivWeatherIcon.visibility = View.GONE
                        btnSearch.visibility = View.INVISIBLE
                        pbLoadingWeather.visibility = View.VISIBLE
                    }

                }
                is State.Content -> {
                    with(binding) {
                        pbLoadingWeather.visibility = View.GONE
                        tvCurrentWeather.text = it.receivedWeather.currentWeather.toString()
                        tvCurrentLocation.text = it.receivedWeather.locationWeather.toString()
                        ivWeatherIcon.visibility = View.VISIBLE
                        btnSearch.visibility = View.VISIBLE
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