package com.example.catbreedsapp.presentation.cat_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catbreedsapp.domain.use_case.GetCatsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CatListViewModel @Inject constructor(private val getCatsUseCase: GetCatsUseCase) : ViewModel(){

    private val _state = mutableStateOf(CatListState())
    //private because we don't want to modify the content of this state in composables, we can access mutable state (now immutable) in the viewmodel
    val state: State<CatListState> = _state

    init {
        getCats()
    }

    private fun getCats(){
        getCatsUseCase().map {
            _state.value = CatListState(cats = it)
        }.launchIn(viewModelScope)
    }
}