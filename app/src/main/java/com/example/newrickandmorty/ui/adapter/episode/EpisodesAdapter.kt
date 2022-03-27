package com.example.newrickandmorty.ui.adapter.episode

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newrickandmorty.base.BaseDiffUtilItemCallback
import com.example.newrickandmorty.common.extensions.setImage
import com.example.newrickandmorty.data.models.CharacterModel
import com.example.newrickandmorty.data.models.EpisodesModel
import com.example.newrickandmorty.databinding.ItemCharacterBinding
import com.example.newrickandmorty.databinding.ItemEpisodeBinding
import com.example.newrickandmorty.ui.adapter.character.CharacterAdapter

class EpisodesAdapter()
    : PagingDataAdapter<EpisodesModel, EpisodesAdapter.EpisodeViewHolder>(
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