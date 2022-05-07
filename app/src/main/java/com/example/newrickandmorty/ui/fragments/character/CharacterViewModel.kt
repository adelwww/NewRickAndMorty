package com.example.newrickandmorty.ui.fragments.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.newrickandmorty.base.BaseViewModel
import com.example.newrickandmorty.data.remote.models.CharacterModel
import com.example.newrickandmorty.data.remote.models.RickAndMortyResponse
import com.example.newrickandmorty.data.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : BaseViewModel() {

    var page = 1
    var isLoading: Boolean = false

    private val _characterState = MutableLiveData<RickAndMortyResponse<CharacterModel>>()
    val characterState: LiveData<RickAndMortyResponse<CharacterModel>> = _characterState

    private val _characterLocalState = MutableLiveData<List<CharacterModel>>()
    val characterLocalState: LiveData<List<CharacterModel>> = _characterLocalState

    fun fetchCharacters() {
        isLoading = true
        viewModelScope.launch {
            characterRepository.fetchCharacters(page).collect(_characterState) {
                page++
                isLoading = false
            }

        }
    }

    fun getCharacters() = characterRepository.getCharacters().collect(_characterLocalState)
}