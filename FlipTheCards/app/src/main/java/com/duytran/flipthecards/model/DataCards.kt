package com.duytran.flipthecards.model

data class DataCards(
    val id : Int,
    val image: Int,
    var isFlipped: Boolean = false,
    val position: Int
)
