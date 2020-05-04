package com.javo_soft.solarsystemapp.model

import com.google.gson.annotations.SerializedName

data class Planet(
    @SerializedName("planet")
    var name: String?,
    @SerializedName("description")
    var description: String?,
    @SerializedName("type")
    var type: String?,
    @SerializedName("orbital_period_in_days")
    var orbitalPeriod: Int?,
    @SerializedName("satellites")
    var satellites: Int?,
    @SerializedName("radius_in_km")
    var radius: Float?,
    @SerializedName("planet_picture")
    var imageUrl: String?
)