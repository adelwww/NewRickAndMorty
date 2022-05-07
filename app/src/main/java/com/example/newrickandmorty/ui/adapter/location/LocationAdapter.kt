package com.example.newrickandmorty.ui.adapter.location

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newrickandmorty.base.BaseDiffUtilItemCallback
import com.example.newrickandmorty.data.remote.models.LocationModel
import com.example.newrickandmorty.databinding.ItemLocationBinding

class LocationAdapter () : ListAdapter<LocationModel, LocationAdapter.LocationViewHolder>(
    BaseDiffUtilItemCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        return LocationViewHolder(
            ItemLocationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false))
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class LocationViewHolder(
        private val binding: ItemLocationBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun onBind(locationModel: LocationModel) = with(binding) {

            binding.tvName.text = locationModel.name
            binding.tvLocation.text = locationModel.type
        }
    }
}