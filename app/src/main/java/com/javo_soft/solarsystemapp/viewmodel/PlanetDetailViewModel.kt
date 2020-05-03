package com.javo_soft.solarsystemapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.javo_soft.solarsystemapp.model.Planet

class PlanetDetailViewModel: ViewModel() {

    val planetLiveData = MutableLiveData<Planet>()

    fun fetch() {

        planetLiveData.value = Planet(
            name = "Venus",
            description = "desc1",
            type = "type1",
            orbitalPeriod = 30,
            satellites = 2,
            radius = 1000.0f,
            imageUrl = ""
        )

    }

}