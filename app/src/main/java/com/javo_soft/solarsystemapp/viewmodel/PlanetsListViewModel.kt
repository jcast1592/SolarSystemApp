package com.javo_soft.solarsystemapp.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.javo_soft.solarsystemapp.model.Planet
import com.javo_soft.solarsystemapp.model.PlanetApiService
import com.javo_soft.solarsystemapp.model.PlanetDatabase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class PlanetsListViewModel(application: Application): BaseViewModel(application) {

    private val planetsService = PlanetApiService()
    private val compositeDisposable = CompositeDisposable()

    val planets = MutableLiveData<List<Planet>>()
    val errorLoading = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchFromRemote()
    }

    private fun fetchFromRemote() {
        loading.value = true
        val disposable = getDisposable()
        compositeDisposable.add(disposable)
    }

    private fun getDisposable(): Disposable {
        return planetsService.getPlanets()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object: DisposableSingleObserver<List<Planet>>() {

                override fun onSuccess(planetList: List<Planet>) {
                    storeLocally(planetList)
                }

                override fun onError(error: Throwable) {
                    loading.value = false
                    errorLoading.value = true
                    error.printStackTrace()
                }

            } )
    }

    private fun planetsRetrieved(planetList: List<Planet>) {
        planets.value = planetList
        errorLoading.value = false
        loading.value = false
    }

    private fun storeLocally(planetList: List<Planet>) {
        launch {
            val dao = PlanetDatabase(getApplication()).planetDao()
            dao.deleteAllPlanets()
            val result = dao.insertAll(*planetList.toTypedArray())
            var i = 0
            while (i < planetList.size) {
                planetList[i].uuid = result[i].toInt()
                i++
            }
            planetsRetrieved(planetList)
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}