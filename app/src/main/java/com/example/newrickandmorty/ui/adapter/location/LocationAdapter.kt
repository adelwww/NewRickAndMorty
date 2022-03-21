package com.example.newrickandmorty.ui.adapter.location

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newrickandmorty.data.models.LocationModel
import com.example.newrickandmorty.databinding.ItemLocationBinding

class LocationAdapter (): RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {

    private var list: List<LocationModel> = arrayListOf()

    fun setList(list: List<LocationModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder =
        LocationViewHolder(
            ItemLocationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class LocationViewHolder(
        private val binding: ItemLocationBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun onBind(locationModel: LocationModel) = with(binding) {

            binding.tvName.text = locationModel.name
            binding.tvLocation.text = locationModel.type

        }

    }

}