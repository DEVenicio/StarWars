package com.venicio.starwars.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.venicio.starwars.data.model.People
import com.venicio.starwars.databinding.ItemPeopleBinding
import com.venicio.starwars.view.ui.MainFragmentDirections

class StarWarsAdapter :
    PagingDataAdapter<People, StarWarsAdapter.StarWarsVH>(StarDiffUtilCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarWarsVH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPeopleBinding.inflate(inflater, parent, false)

        return StarWarsVH(binding)
    }

    override fun onBindViewHolder(holder: StarWarsVH, position: Int) {
        holder.bindPeople(getItem(position)!!)
    }


    class StarWarsVH(private val binding: ItemPeopleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private var idSpecie: Int = 1

        fun bindPeople(data: People) {
            binding.tvInputNamePeople.text = data.name
            binding.tvInputHeight.text = data.height
            binding.tvInputGender.text = data.gender
            binding.tvInputMass.text = data.mass


            binding.cvPeople.setOnClickListener {
                val url = data.url.replace("https://swapi.dev/api/people/", "")
                val idPeople = url.replace("/", "").toInt()

                val urlPlanet = data.homeworld?.replace("https://swapi.dev/api/planets/", "")
                val idPlanet = urlPlanet?.replace("/", "")?.toInt()


                data.species?.forEach {
                    val urlSpecie = it.replace("https://swapi.dev/api/species/", "")
                    val specie = urlSpecie.replace("/", "").toInt()
                    idSpecie = specie
                }

                val direction =
                    MainFragmentDirections.actionMainFragmentToPeopleDetailFragment(
                        idPeople,
                        idPlanet!!,
                        idSpecie
                    )
                binding.root.findNavController().navigate(direction)
            }
        }
    }


    class StarDiffUtilCallback : DiffUtil.ItemCallback<People>() {
        override fun areItemsTheSame(oldItem: People, newItem: People): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: People, newItem: People): Boolean {
            return oldItem.name == newItem.name
        }
    }

}





