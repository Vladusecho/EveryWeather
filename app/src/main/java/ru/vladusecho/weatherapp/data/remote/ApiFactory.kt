package ru.vladusecho.weatherapp.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.vladusecho.weatherapp.domain.entities.Weather
import java.util.concurrent.TimeUnit

object ApiFactory {

    private const val BASE_URL = "https://api.weatherapi.com/v1/"

    private fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
              level = HttpLoggingInterceptor.Level.BODY
            })
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    private fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun createWeatherApiService(): ApiService {
        val client = provideHttpClient()
        val retrofit = provideRetrofit(client)
        return retrofit.create(ApiService::class.java)
    }
}