package com.javo_soft.solarsystemapp.model

import io.reactivex.Single
import retrofit2.http.GET

interface PlanetsApi {

    @GET("planetsApi/blob/master/dataset/planets_dataset.json")
    fun getPlanets(): Single<List<Planet>>

}