package com.example.newrickandmorty.ui.fragments.location

import androidx.lifecycle.ViewModel
import com.example.newrickandmorty.base.BaseViewModel
import com.example.newrickandmorty.data.remote.repository.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val locationRepository: LocationRepository
): BaseViewModel() {

    fun fetchLocation() = locationRepository.fetchLocation()

}