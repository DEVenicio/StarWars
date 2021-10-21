package com.venicio.starwars.view.ui

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.venicio.starwars.R
import com.venicio.starwars.data.repository.StarWarsRepository
import com.venicio.starwars.databinding.FragmentMainBinding
import com.venicio.starwars.view.adapter.StarWarsAdapter
import com.venicio.starwars.viewmodel.StarWarsViewModel
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val sViewModel: StarWarsViewModel by viewModel {
        parametersOf(StarWarsRepository())
    }
    private lateinit var recyclerAdapter: StarWarsAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentMainBinding.inflate(layoutInflater)

        setHasOptionsMenu(true)
        setupRecycler()
        setupObserver()



        return (binding.root)
    }

    private fun setupRecycler() {
        binding.rvListPeople.apply {
            recyclerAdapter = StarWarsAdapter()
            adapter = recyclerAdapter
        }
    }

    private fun setupObserver() {
        lifecycleScope.launchWhenCreated {
            sViewModel.searchPeople().collectLatest {
                recyclerAdapter.submitData(it)
            }
        }
        binding.ProgressBarListPeople.visibility = View.GONE
        binding.rvListPeople.visibility = View.VISIBLE
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.star_wars_menu, menu)

        val menuItem: MenuItem = menu.findItem(R.id.idSearch)


        super.onCreateOptionsMenu(menu, inflater)
    }

}