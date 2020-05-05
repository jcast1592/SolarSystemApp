package com.javo_soft.solarsystemapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.javo_soft.solarsystemapp.model.Planet
import com.javo_soft.solarsystemapp.model.PlanetApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class PlanetsListViewModel: ViewModel() {

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
                    planets.value = planetList
                    errorLoading.value = false
                    loading.value = false
                }

                override fun onError(error: Throwable) {
                    errorLoading.value = true
                    loading.value = false
                    error.printStackTrace()
                }

            } )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}