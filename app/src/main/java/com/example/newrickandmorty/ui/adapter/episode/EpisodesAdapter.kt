package com.example.newrickandmorty.ui.adapter.episode

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newrickandmorty.data.models.EpisodesModel
import com.example.newrickandmorty.databinding.ItemEpisodeBinding

class EpisodesAdapter(): RecyclerView.Adapter<EpisodesAdapter.EpisodesViewHolder>() {

    private var list: List<EpisodesModel> = arrayListOf()

    fun setList(list: List<EpisodesModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodesViewHolder =
        EpisodesViewHolder(
            ItemEpisodeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: EpisodesViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class EpisodesViewHolder(
        private val binding: ItemEpisodeBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun onBind(episodesModel: EpisodesModel) = with(binding) {

           binding.tvName.text = episodesModel.name
           binding.tvEpisodes.text = episodesModel.episodes

        }

    }

}