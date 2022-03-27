package com.example.newrickandmorty.ui.fragments.location

import android.util.Log
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newrickandmorty.R
import com.example.newrickandmorty.base.BaseFragment
import com.example.newrickandmorty.common.resource.Resource
import com.example.newrickandmorty.databinding.FragmentLocationBinding
import com.example.newrickandmorty.ui.adapter.location.LocationAdapter
import com.example.newrickandmorty.ui.adapter.paging.CommonLoadStateAdapter
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

    private fun setupAdapter() = with(binding.recyclerLocation) {
        layoutManager = LinearLayoutManager(context)
        adapter = locationAdapter.withLoadStateFooter(CommonLoadStateAdapter {
            locationAdapter.refresh()
        })
        locationAdapter.addLoadStateListener { loadStates ->
            this.isVisible = loadStates.refresh is LoadState.NotLoading
        }
    }

    private fun subscribeToLocation() {
        viewModel.fetchLocations().observe(this){
            lifecycleScope.launchWhenStarted {
                locationAdapter.submitData(it)
            }
        }
    }

}