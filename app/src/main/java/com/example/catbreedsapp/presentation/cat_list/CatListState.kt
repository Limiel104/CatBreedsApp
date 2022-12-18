package com.example.catbreedsapp.presentation.cat_list

import com.example.catbreedsapp.data.model.Cat

data class CatListState(
    val cats: List<Cat> = emptyList()
)