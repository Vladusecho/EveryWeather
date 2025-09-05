package ru.vladusecho.weatherapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Query
import ru.vladusecho.weatherapp.domain.entities.Weather

interface ApiService {

    @GET("forecast.json")
    suspend fun getCurrentWeather(
        @Query("q") city: String,
        @Query("key") apiKey: String = "8961da579f39465098d172508252508",
        @Query("lang") lang: String = "ru"
    ): Weather
}