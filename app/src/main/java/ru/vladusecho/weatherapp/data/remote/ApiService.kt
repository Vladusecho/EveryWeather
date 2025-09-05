package ru.vladusecho.weatherapp.data.remote

import android.content.Context
import android.content.pm.PackageManager
import com.google.gson.internal.GsonBuildConfig
import retrofit2.http.GET
import retrofit2.http.Query
import ru.vladusecho.weatherapp.BuildConfig
import ru.vladusecho.weatherapp.domain.entities.Weather

interface ApiService {

    @GET("forecast.json")
    suspend fun getCurrentWeather(
        @Query("q") city: String,
        @Query("key") apiKey: String = BuildConfig.API_KEY,
        @Query("lang") lang: String = "ru"
    ): Weather
}