package com.example.newrickandmorty.ui.fragments.episode

import androidx.lifecycle.ViewModel
import com.example.newrickandmorty.base.BaseViewModel
import com.example.newrickandmorty.data.remote.repository.EpisodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val episodeRepository: EpisodeRepository
): BaseViewModel() {

    fun fetchEpisode() = episodeRepository.fetchEpisode()

}