package com.example.newrickandmorty.ui.fragments.location

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newrickandmorty.R
import com.example.newrickandmorty.base.BaseFragment
import com.example.newrickandmorty.databinding.FragmentLocationBinding
import com.example.newrickandmorty.ui.adapter.location.LocationAdapter
import com.example.newrickandmorty.utils.PaginationScrollListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationFragment : BaseFragment<FragmentLocationBinding, LocationViewModel>(
    R.layout.fragment_location
) {

    override val binding by viewBinding(FragmentLocationBinding::bind)
    override val viewModel: LocationViewModel by viewModels()
    private val locationAdapter = LocationAdapter()

    override fun setupObserves() {
        subscribeToLocation()
        subscribeToLocationLocal()
    }

    override fun setupViews() {
        setupAdapter()
    }

    private fun setupAdapter() = with(binding.recyclerLocation) {
        val linerLayoutManager = LinearLayoutManager(context)
        layoutManager = linerLayoutManager
        adapter = locationAdapter

        addOnScrollListener(object :
            PaginationScrollListener(linerLayoutManager, {
                if (isOnline(context)) viewModel.fetchLocations()
                else null
            }) {
            override fun isLoading() = viewModel.isLoading
        })
    }

    override fun setupRequests() {
        if (viewModel.locationState.value == null && isOnline(context)) viewModel.fetchLocations()
        else viewModel.getLocations()
    }

    private fun subscribeToLocation() {
        viewModel.locationState.observe(viewLifecycleOwner) {
            locationAdapter.submitList(it.results)
        }
    }

    private fun subscribeToLocationLocal() {
        viewModel.locationLocalState.observe(viewLifecycleOwner) {
            locationAdapter.submitList(it)
        }
    }

}