package com.venicio.starwars.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.venicio.starwars.data.repository.StarWarsRepository
import com.venicio.starwars.databinding.FragmentPeopleDetailBinding
import com.venicio.starwars.viewmodel.StarWarsDetailsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class PeopleDetailFragment : Fragment() {

    private lateinit var binding: FragmentPeopleDetailBinding
    private val args by navArgs<PeopleDetailFragmentArgs>()
    private val detailsViewModel: StarWarsDetailsViewModel by viewModel {
        parametersOf(StarWarsRepository(), args)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPeopleDetailBinding.inflate(layoutInflater)

        setupObserve()

        return (binding.root)
    }

    private fun setupObserve() {
        detailsViewModel.getDetailPeople()
        detailsViewModel.peopleDetail.observe(viewLifecycleOwner, Observer {

            binding.tvInputNamePeople.text = it.name
            binding.tvInputHeight.text = it.height
            binding.tvInputMass.text = it.mass
            binding.tvInputHairColor.text = it.hair_color
            binding.tvInputSkinColor.text = it.skin_color
            binding.tvInputEyeColor.text = it.eye_color
            binding.tvInputBirthYear.text= it.birth_year
            binding.tvInputGenero.text = it.gender
        })

        detailsViewModel.getPlanet()
        detailsViewModel.peoplePlanet.observe(viewLifecycleOwner, Observer {
            binding.tvInputPlanet.text = it.name
        })

        detailsViewModel.getSpecie()
        detailsViewModel.peopleSpecie.observe(viewLifecycleOwner, Observer {
            binding.tvInputSpecie.text = it.name

            binding.ProgressBarDetail.visibility = View.GONE
            binding.cvContainerDetail.visibility = View.VISIBLE
        })
    }



}