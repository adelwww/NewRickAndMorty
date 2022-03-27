package com.example.newrickandmorty.ui.fragments.location

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.newrickandmorty.base.BaseViewModel
import com.example.newrickandmorty.data.repository.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val locationRepository: LocationRepository
): BaseViewModel() {

    fun fetchLocations() = locationRepository.fetchLocations().cachedIn(viewModelScope)

}