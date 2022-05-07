package com.example.newrickandmorty.ui.fragments.location

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.newrickandmorty.base.BaseViewModel
import com.example.newrickandmorty.data.remote.models.LocationModel
import com.example.newrickandmorty.data.remote.models.RickAndMortyResponse
import com.example.newrickandmorty.data.repository.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val locationRepository: LocationRepository
): BaseViewModel() {

    var page = 1
    var isLoading: Boolean = false

    private val _locationState = MutableLiveData<RickAndMortyResponse<LocationModel>>()
    val locationState: MutableLiveData<RickAndMortyResponse<LocationModel>> = _locationState

    private val _locationLocalState = MutableLiveData<List<LocationModel>>()
    val locationLocalState: LiveData<List<LocationModel>> = _locationLocalState

    fun fetchLocations() {
        isLoading = true
        viewModelScope.launch {
            locationRepository.fetchLocations(page).collect(_locationState) {
                page++
                isLoading = false
            }

        }
    }

    fun getLocations() = locationRepository.getLocations().collect(_locationLocalState)
}