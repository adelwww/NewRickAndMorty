package com.example.newrickandmorty.ui.fragments.character

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newrickandmorty.R
import com.example.newrickandmorty.base.BaseFragment
import com.example.newrickandmorty.databinding.FragmentCharacterBinding
import com.example.newrickandmorty.ui.adapter.character.CharacterAdapter
import com.example.newrickandmorty.utils.PaginationScrollListener
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

    private fun setupAdapter() = with(binding.recyclerCharacter) {
        val linerLayoutManager = LinearLayoutManager(context)
        layoutManager = linerLayoutManager
        adapter = characterAdapter

        addOnScrollListener(object :
            PaginationScrollListener(linerLayoutManager, {
                if (isOnline(context)) viewModel.fetchCharacters()
                else null
            }) {
            override fun isLoading() = viewModel.isLoading
        })
    }

    override fun setupObserves() {
        subscribeToCharacter()
        subscribeToCharacterLocal()
    }

    override fun setupRequests() {
        if (viewModel.characterState.value == null && isOnline(context)) viewModel.fetchCharacters()
        else viewModel.getCharacters()
    }

    private fun subscribeToCharacter() {
        viewModel.characterState.observe(viewLifecycleOwner) {
            characterAdapter.submitList(it.results)
        }
    }

    private fun subscribeToCharacterLocal() {
        viewModel.characterLocalState.observe(viewLifecycleOwner) {
            characterAdapter.submitList(it)
        }
    }
}