package com.example.newrickandmorty.ui.adapter.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.example.newrickandmorty.databinding.ItemLoadStateFooterViewBinding

class CommonLoadStateViewHolder(
    private val binding: ItemLoadStateFooterViewBinding,
    retry: () -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.retryButton.setOnClickListener {
            retry.invoke()
        }
    }

    fun bind(loadState: LoadState) {
        if (loadState is LoadState.Error) {
            binding.errorMsg.text = loadState.error.localizedMessage
        }
        binding.progressBar.isVisible = loadState is LoadState.Loading
        binding.retryButton.isVisible = loadState is LoadState.Error
        binding.errorMsg.isVisible = loadState is LoadState.Error
    }

    companion object {
        fun create(parent: ViewGroup, retry: () -> Unit): CommonLoadStateViewHolder {
            return CommonLoadStateViewHolder(
                ItemLoadStateFooterViewBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                ),
                retry
            )
        }
    }
}