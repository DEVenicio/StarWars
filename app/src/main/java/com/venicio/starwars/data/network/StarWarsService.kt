package com.venicio.starwars.data.network

import com.venicio.starwars.data.model.People
import com.venicio.starwars.data.model.PeopleResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StarWarsService {

    @GET("people/")
   suspend fun fetchPeopleList(
        @Query("page") page: Int
   ) : PeopleResponse

   @GET("people/{people_id}")
   suspend fun fetchPeopleDetail(
       @Path("people_id") id: Int
   ) : People

   @GET("planets/{planet_id}")
   suspend fun fetchPeoplePlanet(
       @Path("planet_id") id: Int
   ) : People

   @GET("species/{specie_id}")
   suspend fun fetchPeopleSpecie(
       @Path("specie_id") id: Int
   ) : People


    companion object {
        const val BASE_URL = "https://swapi.dev/api/"
    }
}