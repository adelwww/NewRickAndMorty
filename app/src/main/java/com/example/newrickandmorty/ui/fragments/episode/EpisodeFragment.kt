package com.example.newrickandmorty.ui.fragments.episode

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newrickandmorty.R
import com.example.newrickandmorty.base.BaseFragment
import com.example.newrickandmorty.databinding.FragmentEpisodeBinding
import com.example.newrickandmorty.ui.adapter.episode.EpisodesAdapter
import com.example.newrickandmorty.utils.PaginationScrollListener
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
        subscribeToEpisodeLocal()
    }

    override fun setupViews() {
        setupAdapter()
    }

    private fun setupAdapter() = with(binding.recyclerEpisode) {
        val linerLayoutManager = LinearLayoutManager(context)
        layoutManager = linerLayoutManager
        adapter = episodesAdapter

        addOnScrollListener(object :
            PaginationScrollListener(linerLayoutManager, {
                if (isOnline(context)) viewModel.fetchEpisodes()
                else null
            }) {
            override fun isLoading() = viewModel.isLoading
        })
    }

    override fun setupRequests() {
        if (viewModel.episodeState.value == null && isOnline(context)) viewModel.fetchEpisodes()
        else viewModel.getEpisodes()
    }

    private fun subscribeToEpisode() {
        viewModel.episodeState.observe(viewLifecycleOwner) {
            episodesAdapter.submitList(it.results)
        }
    }

    private fun subscribeToEpisodeLocal() {
        viewModel.episodeLocalState.observe(viewLifecycleOwner) {
            episodesAdapter.submitList(it)
        }
    }

}