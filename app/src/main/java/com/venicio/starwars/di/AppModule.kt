package com.venicio.starwars.di

import com.venicio.starwars.data.repository.StarWarsRepository
import com.venicio.starwars.view.ui.PeopleDetailFragmentArgs
import com.venicio.starwars.viewmodel.StarWarsDetailsViewModel
import com.venicio.starwars.viewmodel.StarWarsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { (rp: StarWarsRepository) -> StarWarsViewModel(rp) }
    viewModel { (rp: StarWarsRepository, arguments: PeopleDetailFragmentArgs) -> StarWarsDetailsViewModel(rp, arguments) }
}