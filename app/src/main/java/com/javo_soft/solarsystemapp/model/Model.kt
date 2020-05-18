package com.javo_soft.solarsystemapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Planet(

    @ColumnInfo(name = "planet_name")
    @SerializedName("planet")
    var name: String?,

    @ColumnInfo(name = "description")
    @SerializedName("description")
    var description: String?,

    @ColumnInfo(name = "type")
    @SerializedName("type")
    var type: String?,

    @ColumnInfo(name = "orbital_period_in_days")
    @SerializedName("orbital_period_in_days")
    var orbitalPeriod: Int?,

    @ColumnInfo(name = "satellites")
    @SerializedName("satellites")
    var satellites: Int?,

    @ColumnInfo(name = "radius_in_km")
    @SerializedName("radius_in_km")
    var radius: Float?,

    @ColumnInfo(name = "planet_picture")
    @SerializedName("planet_picture")
    var imageUrl: String?
) {

    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0

}