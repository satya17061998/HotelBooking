package com.example.eater

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.fasterxml.jackson.databind.ObjectMapper
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import okhttp3.Interceptor

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory


class MyDishApplication: Application() {
    public lateinit var httpApiService: DishesHttpApiService
    public lateinit var preference : SharedPreferences

    public lateinit var pets: EaterInterface


    override fun onCreate() {
        super.onCreate()

        preference =  getSharedPreferences("SaveData_Locally", Context.MODE_PRIVATE)

        val token = preference.getString("token", "defaultToken")

        println("token in my dish application $token")

        httpApiService = initHttpApiService(token)

        pets = initPetService(token)
    }

    private fun initPetService(token: String?): EaterInterface
    {

        val loggingInterceptor = HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder().addInterceptor { chain ->
            val newRequest: Request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer $token")
                .build()
            chain.proceed(newRequest)
        }.addInterceptor(loggingInterceptor)          //gives details about connection
            .build()

        var retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl("https://android-kanini-course.cloud/hotelBooking/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(EaterInterface::class.java)
    }

    private fun initHttpApiService(token:String?): DishesHttpApiService {

        //preference =  getSharedPreferences("SaveData_Locally", Context.MODE_PRIVATE)

        //val token = preference.getString("token", "abctoken")

        val loggingInterceptor = HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder().addInterceptor { chain ->
            val newRequest: Request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer $token")
                .build()
            chain.proceed(newRequest)
        }.addInterceptor(loggingInterceptor)          //gives details about connection
            .build()

        val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl("https://android-kanini-course.cloud/")
            .addConverterFactory(JacksonConverterFactory.create(ObjectMapper()))
            .build()

        return retrofit.create(DishesHttpApiService::class.java)

    }
}