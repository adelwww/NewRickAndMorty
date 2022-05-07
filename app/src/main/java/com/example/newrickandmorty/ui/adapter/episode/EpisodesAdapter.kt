package com.example.newrickandmorty.ui.adapter.episode

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newrickandmorty.base.BaseDiffUtilItemCallback
import com.example.newrickandmorty.data.remote.models.EpisodesModel
import com.example.newrickandmorty.databinding.ItemEpisodeBinding

class EpisodesAdapter : ListAdapter<EpisodesModel, EpisodesAdapter.EpisodeViewHolder>(
    BaseDiffUtilItemCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return EpisodeViewHolder(
            ItemEpisodeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false))
    }



    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }

    }

    inner class EpisodeViewHolder(
        private val binding: ItemEpisodeBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun onBind(episodesModel: EpisodesModel) = with(binding) {

            binding.tvName.text = episodesModel.name
            binding.tvEpisodes.text = episodesModel.episodes

        }
    }
}