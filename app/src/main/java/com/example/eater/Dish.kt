package com.example.eater

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

data class Dish(
    //@JsonProperty("id")  //something new              //here is the error
    val id: Int = 0,
    val name: String = "",
    val url: String = "",
    val roomsLeft: Int = 0,
    val pricePerNight: Int = 0,
    val reservedByPeople: Int = 0
    )
