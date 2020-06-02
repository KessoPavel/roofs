package com.roof.roofs.database.entity

data class RoofOrderEntity(
    val id: Long,
    var client: String,
    var address: String,
    var skate: Int,
    var leftSlope: Int,
    var rightSlope: Int
)