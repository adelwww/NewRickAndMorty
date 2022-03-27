package com.example.newrickandmorty.ui.fragments.episode

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
import com.example.newrickandmorty.databinding.FragmentEpisodeBinding
import com.example.newrickandmorty.ui.adapter.episode.EpisodesAdapter
import com.example.newrickandmorty.ui.adapter.paging.CommonLoadStateAdapter
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

    private fun setupAdapter() = with(binding.recyclerEpisode) {
        layoutManager = LinearLayoutManager(context)
        adapter = episodesAdapter.withLoadStateFooter(CommonLoadStateAdapter {
            episodesAdapter.refresh()
        })
        episodesAdapter.addLoadStateListener { loadStates ->
            this.isVisible = loadStates.refresh is LoadState.NotLoading
        }
    }

    private fun subscribeToEpisode() {
        viewModel.fetchEpisodes().observe(this){
            lifecycleScope.launchWhenStarted {
                episodesAdapter.submitData(it)
            }
        }
    }

}