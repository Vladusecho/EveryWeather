package ru.vladusecho.weatherapp.presentation.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.vladusecho.weatherapp.R
import ru.vladusecho.weatherapp.domain.entities.ConditionWeather
import ru.vladusecho.weatherapp.domain.entities.HourWeather

class ForecastAdapter : RecyclerView.Adapter<ForecastAdapter.MyViewHolder>() {

    private val initList = mutableListOf<HourWeather>().apply {
        add(HourWeather("22", "22", "22", "22", "22", ConditionWeather("22", "22")))
        add(HourWeather("22", "22", "22", "22", "22", ConditionWeather("22", "22")))
        add(HourWeather("22", "22", "22", "22", "22", ConditionWeather("22", "22")))
        add(HourWeather("22", "22", "22", "22", "22", ConditionWeather("22", "22")))
        add(HourWeather("22", "22", "22", "22", "22", ConditionWeather("22", "22")))
    }

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
        holder.tvName.text = initList[position].time
    }

    override fun getItemCount(): Int {
        return initList.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName = view.findViewById<TextView>(R.id.tv_name)
    }
}