package com.venicio.starwars.data.model

data class People(
    val url: String,
    val name: String,
    val height: String?,
    val gender: String?,
    val mass: String?,
    val hair_color: String?,
    val skin_color: String?,
    val eye_color: String?,
    val birth_year: String?,
    val homeworld: String?,
    val species: List<String>?
)




