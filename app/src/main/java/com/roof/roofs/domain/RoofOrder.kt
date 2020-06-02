package com.roof.roofs.domain

data class RoofOrder(
    var client: String,
    var address: String,
    var skate: Int,
    var leftSlope: Int,
    var rightSlope: Int
)