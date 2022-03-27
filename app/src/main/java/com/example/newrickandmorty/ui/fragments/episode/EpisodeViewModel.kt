package com.example.newrickandmorty.ui.fragments.episode

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.newrickandmorty.base.BaseViewModel
import com.example.newrickandmorty.data.repository.EpisodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val episodeRepository: EpisodeRepository
): BaseViewModel() {

    fun fetchEpisodes() = episodeRepository.fetchEpisodes().cachedIn(viewModelScope)

}