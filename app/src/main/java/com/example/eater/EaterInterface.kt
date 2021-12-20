package com.example.eater

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface EaterInterface {

//amit
    @GET("users/me/reservations")
//    suspend fun getPets(): Response<PetList>
    suspend fun getMyorders(): ReservationList
//    suspend fun getPets(): List<Pets>
//    suspend fun getPets(token: String): List<Pets>


    @GET("hotels")
    suspend fun getdishes(): Hotel


    @DELETE("users/me/reservations/{reservationId}")
    suspend fun deleteOrder(@Path("reservationId") id: Int): Response<ResponseBody>




    @GET("users")
//    suspend fun getPets(): Response<PetList>
    suspend fun getUsers(): Users


    @GET("users/me/loginHistory")
    suspend fun getHistory(): History


    @GET("hotels")
    suspend fun getDishes(): com.example.eater.Hotel



    @POST("users/me/reservations")
    suspend fun createOrder(@Body requestBody: RequestBody) : Response<ResponseBody>


}

