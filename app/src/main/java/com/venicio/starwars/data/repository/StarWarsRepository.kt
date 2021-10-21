package com.venicio.starwars.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.venicio.starwars.data.Constants
import com.venicio.starwars.data.StarWarsPagingSource
import com.venicio.starwars.data.model.People
import com.venicio.starwars.data.network.StarWarsClient
import kotlinx.coroutines.flow.Flow

class StarWarsRepository() {

    private val service = StarWarsClient.getInstance()

    suspend fun getPeopleList(): Flow<PagingData<People>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constants.NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { StarWarsPagingSource(service) }
        ).flow
    }

    suspend fun getDetailPeople(id: Int) = service.fetchPeopleDetail(id)

    suspend fun getPlanet(id: Int) = service.fetchPeoplePlanet(id)

    suspend fun getSpecie(id: Int) = service.fetchPeopleSpecie(id)

}