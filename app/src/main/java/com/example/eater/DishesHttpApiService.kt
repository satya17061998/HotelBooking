package com.example.eater

import retrofit2.http.GET

interface DishesHttpApiService {

    @GET("/hotelBooking/hotels")
    suspend fun getAllDishes(): DishListResponse
}