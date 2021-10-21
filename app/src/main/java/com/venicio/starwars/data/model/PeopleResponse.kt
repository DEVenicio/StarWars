package com.venicio.starwars.data.model


data class PeopleResponse(
    val next: String?,
    val results: List<People>
)
