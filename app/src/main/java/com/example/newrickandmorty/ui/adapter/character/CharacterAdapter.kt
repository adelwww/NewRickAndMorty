package com.example.newrickandmorty.ui.adapter.character

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newrickandmorty.common.extensions.setImage
import com.example.newrickandmorty.data.models.CharacterModel
import com.example.newrickandmorty.databinding.ItemCharacterBinding

class CharacterAdapter (
  //  val onItemClick: (id: Int) ->Unit
) : RecyclerView.Adapter<CharacterAdapter.CharaViewHolder>() {

    private var list: List<CharacterModel> = arrayListOf()

    fun setList(list: List<CharacterModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharaViewHolder =
        CharaViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CharaViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class CharaViewHolder(
        private val binding: ItemCharacterBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun onBind(characterModel: CharacterModel) = with(binding) {
//            itemView.setOnClickListener {
//                onItemClick(characterCv.id)
//            }
            statusCharacterTv.text = characterModel.status
            nameCharacterTv.text = characterModel.name
            characterIm.setImage(characterModel.image)

        }

    }

}