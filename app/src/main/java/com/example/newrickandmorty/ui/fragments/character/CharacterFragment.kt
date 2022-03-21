package com.example.newrickandmorty.ui.fragments.character

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.newrickandmorty.R
import com.example.newrickandmorty.base.BaseFragment
import com.example.newrickandmorty.common.resource.Resource
import com.example.newrickandmorty.databinding.FragmentCharacterBinding
import com.example.newrickandmorty.ui.adapter.character.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment : BaseFragment<FragmentCharacterBinding, CharacterViewModel>(
    R.layout.fragment_character
) {
    override val binding by viewBinding(FragmentCharacterBinding::bind)
    override val viewModel: CharacterViewModel by viewModels()
    private val characterAdapter = CharacterAdapter()

    override fun setupObserves() {
        subscribeToCharacter()
    }

    override fun setupViews() {
        setupAdapter()
    }

    private fun setupAdapter() = with(binding) {
        recyclerCharacter.adapter = characterAdapter
        recyclerCharacter.layoutManager = LinearLayoutManager(context)
    }

    private fun subscribeToCharacter() {
        viewModel.fetchCharacter().observe(viewLifecycleOwner){
            when(it){
                is Resource.Loading -> {
                    Log.e("anime","loading")
                }
                is Resource.Error -> {
                    Log.e("anime","error")
                }
                is Resource.Success -> {
                    it.data?.results?.let { it1 -> characterAdapter.setList(it1) }
                }
            }
        }
    }

}