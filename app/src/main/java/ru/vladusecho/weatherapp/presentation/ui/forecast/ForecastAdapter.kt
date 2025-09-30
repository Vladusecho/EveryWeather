package ru.vladusecho.weatherapp.presentation.ui.forecast

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.w3c.dom.Text
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
        val currentElement = forecastList[position]
        holder.tvTime.text = currentElement.time.split(" ")[1]
        holder.tvTemp.text = currentElement.temp
        holder.tvWind.text = currentElement.getWindAsText()
        holder.tvInfo.text = currentElement.describing.text
        holder.ivIcon.load("https:" + currentElement.describing.icon) {
            crossfade(true)
        }
        holder.tvRain.text = currentElement.getRainChanceAsText()
    }

    override fun getItemCount(): Int {
        return forecastList.size
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTemp = view.findViewById<TextView>(R.id.tvCurrentTemp)
        val tvTime = view.findViewById<TextView>(R.id.tvTime)
        val tvWind = view.findViewById<TextView>(R.id.tvWind)
        val tvInfo = view.findViewById<TextView>(R.id.tvInfo)
        val ivIcon = view.findViewById<ImageView>(R.id.ivWeatherIcon)
        val tvRain = view.findViewById<TextView>(R.id.tvRain)
    }
}