package com.example.newrickandmorty.ui.fragments.character.detail

import android.util.Log
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.noreflection.R
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.newrickandmorty.base.BaseFragment
import com.example.newrickandmorty.common.resource.Resource
import com.example.newrickandmorty.data.models.CharacterModel
import com.example.newrickandmorty.databinding.FragmentCharacterDetailBinding
import com.example.newrickandmorty.ui.adapter.character.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
//class CharacterDetailFragment(
//    private val characterModel: CharacterModel
//) : BaseFragment<FragmentCharacterDetailBinding, CharacterDetailViewModel>(
//    com.example.newrickandmorty.R.layout.fragment_character_detail
//) {
//
//    override val binding by viewBinding(FragmentCharacterDetailBinding::bind)
//    override val viewModel: CharacterDetailViewModel by viewModels()
//
//    override fun setupObserves() {
//        subscribeToCharacterId(characterModel)
//    }
//
//    private fun subscribeToCharacterId(characterModel: CharacterModel) {
////        viewModel.fetchCharacterId(id).observe(viewLifecycleOwner) {
////            binding.nameCharacterDt.text = characterModel.name
////            Glide.with(binding.characterImage)
////                .load(characterModel.image)
////                .into(binding.characterImage)
////
////
////        }
//    }
//
//}