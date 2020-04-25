package com.javo_soft.solarsystemapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.javo_soft.solarsystemapp.model.Planet

class PlanetsListViewModel: ViewModel() {

    val planets = MutableLiveData<List<Planet>>()
    val errorLoading = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        val planet1 = Planet("Venus", "desc1", "type1", 30, 2, 1000.0f, "")
        val planet2 = Planet("Jupiter", "desc2", "typ2", 70, 20, 20000.0f, "")
        val planet3 = Planet("Uranus", "desc3", "typ3", 150, 0, 50000.0f, "")
        val planetList: ArrayList<Planet> = arrayListOf(planet1, planet2, planet3)

        planets.value = planetList
        errorLoading.value = false
        loading.value = false
    }

}