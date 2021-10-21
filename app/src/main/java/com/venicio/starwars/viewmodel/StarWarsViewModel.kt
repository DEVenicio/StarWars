package com.venicio.starwars.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.venicio.starwars.data.model.People
import com.venicio.starwars.data.model.PeopleResponse
import com.venicio.starwars.data.repository.StarWarsRepository
import kotlinx.coroutines.flow.Flow


class StarWarsViewModel( private val rp: StarWarsRepository) : ViewModel() {

    private var currentUrlValue: String? = null
    private var currentSearchResult: Flow<PagingData<People>>? = null

    suspend fun searchPeople(): Flow<PagingData<People>> {
        val lastResult = currentSearchResult
        if (  lastResult != null ) {
            return lastResult
        }

        val newResult: Flow<PagingData<People>> = rp.getPeopleList()
            .cachedIn(viewModelScope)
        currentSearchResult = newResult
        return newResult
    }


    private val _peopleList = MutableLiveData<PeopleResponse>()
    val peopleList: LiveData<PeopleResponse> = _peopleList

}