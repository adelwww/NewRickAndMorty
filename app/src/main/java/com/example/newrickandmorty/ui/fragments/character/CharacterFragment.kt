package com.example.newrickandmorty.ui.fragments.character

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newrickandmorty.R
import com.example.newrickandmorty.base.BaseFragment
import com.example.newrickandmorty.databinding.FragmentCharacterBinding
import com.example.newrickandmorty.ui.adapter.character.CharacterAdapter
import com.example.newrickandmorty.ui.adapter.paging.CommonLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment : BaseFragment<FragmentCharacterBinding, CharacterViewModel>(
    R.layout.fragment_character
) {
    override val binding by viewBinding(FragmentCharacterBinding::bind)
    override val viewModel: CharacterViewModel by viewModels()
    private val characterAdapter = CharacterAdapter()

    override fun setupViews() {
        setupAdapter()
    }

    override fun setupObserves() {
        subscribeToCharacter()
    }

    private fun setupAdapter() = with(binding.recyclerCharacter) {
        layoutManager = LinearLayoutManager(context)
        adapter = characterAdapter.withLoadStateFooter(CommonLoadStateAdapter {
            characterAdapter.refresh()
        })
        characterAdapter.addLoadStateListener { loadStates ->
            this.isVisible = loadStates.refresh is LoadState.NotLoading
        }
    }

    private fun subscribeToCharacter() {
        viewModel.fetchCharacters().observe(this){
            lifecycleScope.launchWhenStarted {
                characterAdapter.submitData(it)
            }
        }
    }

}