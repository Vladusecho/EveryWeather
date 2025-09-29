package ru.vladusecho.weatherapp.presentation.ui.forecast

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.vladusecho.weatherapp.R
import ru.vladusecho.weatherapp.domain.entities.ConditionWeather
import ru.vladusecho.weatherapp.domain.entities.HourWeather
import kotlin.random.Random

class ForecastAdapter : RecyclerView.Adapter<ForecastAdapter.MyViewHolder>() {

    var forecastList = arrayListOf<HourWeather>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(
            R.layout.forecast_back,
            parent,
    false
        )
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        holder.tvTime.text = forecastList[position].time.split(" ")[1]
        holder.tvTemp.text = forecastList[position].temp
    }

    override fun getItemCount(): Int {
        return forecastList.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTemp = view.findViewById<TextView>(R.id.tvCurrentTemp)
        val tvTime = view.findViewById<TextView>(R.id.tvTime)
    }
}