package ru.vladusecho.weatherapp.presentation.ui.forecast

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.vladusecho.weatherapp.R
import ru.vladusecho.weatherapp.databinding.ActivityForecastBinding
import ru.vladusecho.weatherapp.domain.entities.HourWeather
import ru.vladusecho.weatherapp.presentation.viewmodels.ForecastViewModel

class ForecastActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this)[ForecastViewModel::class.java]
    }

    private lateinit var adapter: ForecastAdapter

    private val binding by lazy {
        ActivityForecastBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        adapter = ForecastAdapter()
        val forecastList = intent.getParcelableArrayListExtra<HourWeather>("FORECAST_LIST") ?: emptyList()
        adapter.forecastList = forecastList as ArrayList<HourWeather>
        val rv = binding.rvForecast
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter
    }
}