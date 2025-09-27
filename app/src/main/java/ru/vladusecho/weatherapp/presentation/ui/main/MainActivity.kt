package ru.vladusecho.weatherapp.presentation.ui.main

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import ru.vladusecho.weatherapp.R
import ru.vladusecho.weatherapp.databinding.ActivityMainBinding
import ru.vladusecho.weatherapp.presentation.states.State
import ru.vladusecho.weatherapp.presentation.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.btnForecast.visibility = View.INVISIBLE
        loadAnimations(this)
        observeLiveData()
        setListeners()
    }

    private fun setListeners() {
        binding.btnSearch.setOnClickListener {
            viewModel.loadWeather(binding.etCityName.text.toString())
        }
        binding.btnForecast.setOnClickListener {
            Toast.makeText(this, "Soon...", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadAnimations(context: Context) {
        with(binding) {
            upperSlider.startAnimation(
                AnimationUtils.loadAnimation(context, R.anim.slide_in_from_top)
            )
            etCityName.startAnimation(
                AnimationUtils.loadAnimation(context, R.anim.slide_from_right)
            )
            lowerSlider.startAnimation(
                AnimationUtils.loadAnimation(context, R.anim.slide_in_from_down)
            )
            btnSearch.apply {
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
        }
    }

    private fun observeLiveData() {
        viewModel.stateLiveData.observe(this) {
            when (it) {
                State.Loading -> {
                    with(binding) {
                        tvCurrentLocation.text = ""
                        tvCurrentWind.text = ""
                        tvCurrentTemp.text = ""
                        tvActualDate.text = ""
                        tvCurrentInfo.text = ""
                        ivWeatherIcon.visibility = View.GONE
                        btnSearch.visibility = View.INVISIBLE
                        btnForecast.visibility = View.INVISIBLE
                        pbLoadingWeather.visibility = View.VISIBLE
                    }

                }
                is State.Content -> {
                    with(binding) {
                        pbLoadingWeather.visibility = View.GONE
                        tvCurrentLocation.text = it.receivedWeather.locationWeather.toString()
                        tvCurrentWind.text = it.receivedWeather.currentWeather.getWindAsText()
                        tvCurrentTemp.text = it.receivedWeather.currentWeather.getTempAsText()
                        tvActualDate.text = it.receivedWeather.currentWeather.getDateAsText()
                        tvCurrentInfo.text = it.receivedWeather.currentWeather.describing.text
                        ivWeatherIcon.visibility = View.VISIBLE
                        btnSearch.visibility = View.VISIBLE
                        btnForecast.visibility = View.VISIBLE
                        ivWeatherIcon.load("https:" + it.receivedWeather.currentWeather.describing.icon) {
                            crossfade(true)
                        }
                    }
                }
                is State.Error -> {
                    with(binding) {
                        tvCurrentLocation.text = it.errorText
                        pbLoadingWeather.visibility = View.GONE
                        btnSearch.visibility = View.VISIBLE
                    }
                }
            }
        }
    }
}