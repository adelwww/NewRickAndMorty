package com.example.newrickandmorty.ui.fragments.location

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newrickandmorty.R
import com.example.newrickandmorty.base.BaseFragment
import com.example.newrickandmorty.common.resource.Resource
import com.example.newrickandmorty.databinding.FragmentLocationBinding
import com.example.newrickandmorty.ui.adapter.location.LocationAdapter
import com.example.newrickandmorty.ui.fragments.character.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationFragment  : BaseFragment<FragmentLocationBinding, LocationViewModel>(
    R.layout.fragment_location
) {
    override val binding by viewBinding(FragmentLocationBinding::bind)
    override val viewModel: LocationViewModel by viewModels()
    private val locationAdapter = LocationAdapter()

    override fun setupObserves() {
        subscribeToLocation()
    }

    override fun setupViews() {
        setupAdapter()
    }

    private fun setupAdapter() = with(binding) {
        recyclerLocation.adapter = locationAdapter
        recyclerLocation.layoutManager = LinearLayoutManager(context)
    }

    private fun subscribeToLocation() {
        viewModel.fetchLocation().observe(viewLifecycleOwner){
            when(it){
                is Resource.Loading -> {
                    Log.e("anime","loading")
                }
                is Resource.Error -> {
                    Log.e("anime","error")
                }
                is Resource.Success -> {
                    it.data?.results?.let { it1 -> locationAdapter.setList(it1) }
                }
            }
        }
    }

}