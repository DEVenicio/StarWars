package com.venicio.starwars.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.venicio.starwars.data.model.People
import com.venicio.starwars.data.repository.StarWarsRepository
import com.venicio.starwars.view.ui.PeopleDetailFragmentArgs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StarWarsDetailsViewModel(
    private val rp: StarWarsRepository,
    private val args: PeopleDetailFragmentArgs
) : ViewModel(){

    private var detailsResult: People? = null

    private val _peopleDetail = MutableLiveData<People>()
    val peopleDetail: LiveData<People>
    get() = _peopleDetail

    private val _peoplePlanet = MutableLiveData<People>()
    val peoplePlanet: LiveData<People>
    get() = _peoplePlanet

    private val _peopleSpecie = MutableLiveData<People>()
    val peopleSpecie: LiveData<People>
    get() = _peopleSpecie


    fun getDetailPeople() {
        viewModelScope.launch(Dispatchers.IO) {
            detailsResult = rp.getDetailPeople(args.idPeople)
            _peopleDetail.postValue(detailsResult!!)
        }
    }

    fun getPlanet() {
        viewModelScope.launch(Dispatchers.IO) {
            detailsResult = rp.getPlanet(args.idPlanet)
            _peoplePlanet.postValue(detailsResult!!)
        }
    }

    fun getSpecie() {
        viewModelScope.launch(Dispatchers.IO) {
                detailsResult = rp.getSpecie(args.idSpecie)
                _peopleSpecie.postValue(detailsResult!!)
        }
    }

}