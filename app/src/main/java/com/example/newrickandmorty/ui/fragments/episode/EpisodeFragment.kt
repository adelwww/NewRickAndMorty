package com.example.newrickandmorty.ui.fragments.episode

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newrickandmorty.R
import com.example.newrickandmorty.base.BaseFragment
import com.example.newrickandmorty.common.resource.Resource
import com.example.newrickandmorty.databinding.FragmentEpisodeBinding
import com.example.newrickandmorty.ui.adapter.episode.EpisodesAdapter
import com.example.newrickandmorty.ui.fragments.character.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodeFragment : BaseFragment<FragmentEpisodeBinding, EpisodeViewModel>(
    R.layout.fragment_episode
) {

    override val binding by viewBinding(FragmentEpisodeBinding::bind)
    override val viewModel: EpisodeViewModel by viewModels()
    private val episodesAdapter = EpisodesAdapter()

    override fun setupObserves() {
        subscribeToEpisode()
    }

    override fun setupViews() {
        setupAdapter()
    }

    private fun setupAdapter() = with(binding) {
        recyclerEpisode.adapter = episodesAdapter
        recyclerEpisode.layoutManager = LinearLayoutManager(context)
    }

    private fun subscribeToEpisode() {
        viewModel.fetchEpisode().observe(viewLifecycleOwner){
            when(it){
                is Resource.Loading -> {
                    Log.e("anime","loading")
                }
                is Resource.Error -> {
                    Log.e("anime","error")
                }
                is Resource.Success -> {
                    it.data?.results?.let { it1 -> episodesAdapter.setList(it1) }
                }
            }
        }
    }

}