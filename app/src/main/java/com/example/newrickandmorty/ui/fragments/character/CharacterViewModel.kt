package com.example.newrickandmorty.ui.fragments.character

import androidx.lifecycle.ViewModel
import com.example.newrickandmorty.base.BaseViewModel
import com.example.newrickandmorty.data.remote.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
): BaseViewModel() {

    fun fetchCharacter() = characterRepository.fetchCharacter()

}