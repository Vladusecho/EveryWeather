package ru.vladusecho.weatherapp.presentation.ui.forecast

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ru.vladusecho.weatherapp.R
import ru.vladusecho.weatherapp.databinding.ActivityForecastBinding
import ru.vladusecho.weatherapp.domain.entities.HourWeather
import ru.vladusecho.weatherapp.presentation.viewmodels.ForecastViewModel

class ForecastActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this)[ForecastViewModel::class.java]
    }

    private lateinit var forecastAdapter: ForecastAdapter

    private val binding by lazy {
        ActivityForecastBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        setupRecyclerView()
        setupForecastDate()
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun setupForecastDate() {
        val date = intent.getStringExtra(FORECAST_DATE_STRING)
        val dateList = date?.split("-")
        val month = dateList?.get(1)
        val nameMonth = when(month) {
            "01" -> "января"
            "02" -> "февраля"
            "03" -> "марта"
            "04" -> "апреля"
            "05" -> "мая"
            "06" -> "июня"
            "07" -> "июля"
            "08" -> "августа"
            "09" -> "сентября"
            "10" -> "октября"
            "11" -> "ноября"
            "12" -> "декабря"
            else -> "ошибка: неизвестный месяц"
        }
        binding.tvDate.text = getString(
            R.string.date_placeholder,
            dateList?.last(),
            nameMonth,
            dateList?.first()
        )
    }

    private fun setupRecyclerView() {
        forecastAdapter = ForecastAdapter()
        val forecastList = intent.getParcelableArrayListExtra<HourWeather>(
            FORECAST_LIST_HOUR_ITEMS
        ) ?: emptyList()
        forecastAdapter.forecastList = forecastList as ArrayList<HourWeather>
        with(binding.rvForecast) {
            layoutManager = LinearLayoutManager(context)
            adapter = forecastAdapter
        }
    }

    companion object {

        private const val FORECAST_LIST_HOUR_ITEMS = "FORECAST_LIST"
        private const val FORECAST_DATE_STRING = "FORECAST_DATE"

        fun newIntent(
            context: Context,
            forecastList: ArrayList<HourWeather>,
            forecastDate: String): Intent
        {
            return Intent(context, ForecastActivity::class.java).apply {
                putExtra(FORECAST_LIST_HOUR_ITEMS, forecastList)
                putExtra(FORECAST_DATE_STRING, forecastDate)
            }
        }
    }
}