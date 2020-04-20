package com.javo_soft.solarsystemapp.model

data class Planet(
    var name: String?,
    var description: String?,
    var type: String?,
    var orbitalPeriod: Int?,
    var satellites: Int?,
    var radius: Float?,
    var imageUrl: String?
)