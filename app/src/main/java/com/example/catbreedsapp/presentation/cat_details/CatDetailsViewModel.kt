package com.example.catbreedsapp.presentation.cat_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catbreedsapp.domain.use_case.GetCatDetailsUseCase
import com.example.catbreedsapp.presentation.cat_list.CatListState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CatDetailsViewModel @Inject constructor(
    private val getCatDetailsUseCase: GetCatDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CatDetailsState())
    val state: State<CatDetailsState> = _state

    init {
        savedStateHandle.get<String>("catId")?.let { catId ->
            getCat(catId)
        }
    }

    private fun getCat(catId: String){
        getCatDetailsUseCase(catId).map {
            _state.value = CatDetailsState(cat = it)
        }.launchIn(viewModelScope)
    }
}