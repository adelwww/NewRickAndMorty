package com.example.newrickandmorty.ui.fragments.episode

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.newrickandmorty.base.BaseViewModel
import com.example.newrickandmorty.data.remote.models.EpisodesModel
import com.example.newrickandmorty.data.remote.models.RickAndMortyResponse
import com.example.newrickandmorty.data.repository.EpisodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val episodeRepository: EpisodeRepository
): BaseViewModel() {

    var page = 1
    var isLoading: Boolean = false

    private val _episodeState = MutableLiveData<RickAndMortyResponse<EpisodesModel>>()
    val episodeState: MutableLiveData<RickAndMortyResponse<EpisodesModel>> = _episodeState

    private val _episodeLocalState = MutableLiveData<List<EpisodesModel>>()
    val episodeLocalState: LiveData<List<EpisodesModel>> = _episodeLocalState

    fun fetchEpisodes() {
        isLoading = true
        viewModelScope.launch {
            episodeRepository.fetchEpisodes(page).collect(_episodeState) {
                page++
                isLoading = false
            }

        }
    }

    fun getEpisodes() = episodeRepository.getEpisodes().collect(_episodeLocalState)
}