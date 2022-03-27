package com.example.newrickandmorty.ui.adapter.character

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newrickandmorty.base.BaseDiffUtilItemCallback
import com.example.newrickandmorty.common.extensions.setImage
import com.example.newrickandmorty.data.models.CharacterModel
import com.example.newrickandmorty.databinding.ItemCharacterBinding

class CharacterAdapter ()
    : PagingDataAdapter<CharacterModel, CharacterAdapter.CharacterViewHolder>(
    BaseDiffUtilItemCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false))
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class CharacterViewHolder(
        private val binding: ItemCharacterBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun onBind(characterModel: CharacterModel) = with(binding) {
            statusCharacterTv.text = characterModel.status
            nameCharacterTv.text = characterModel.name
            characterIm.setImage(characterModel.image)

        }
    }
}