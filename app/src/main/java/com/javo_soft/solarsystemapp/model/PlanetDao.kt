package com.javo_soft.solarsystemapp.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PlanetDao {

    @Insert
    suspend fun insertAll(vararg planets: Planet): List<Long>

    @Query(value = "SELECT * FROM planet")
    suspend fun getAllPlanets(): List<Planet>

    @Query(value = "SELECT * FROM planet WHERE uuid = :planetId")
    suspend fun getPlanet(planetId: Int): Planet

    @Query(value = "DELETE FROM planet")
    suspend fun deleteAllPlanets()

}