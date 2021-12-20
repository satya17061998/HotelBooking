package com.example.eater

data class Reservation(
    var hotelId: Int = 0,
    var nightsCount: Int = 0
)
data class ReservationList(
    var dishOrders: MutableList<Reservation>
)

data class Hotel1(
    val id: Int = 0,
    val name: String = "",
    val url: String = "",
    val roomsLeft: Int = 0,
    val pricePerNight: Int = 0,
    val reservedByPeople: Int = 0
)

data class Hotel(
    var dishes: MutableList<Hotel1>
)
