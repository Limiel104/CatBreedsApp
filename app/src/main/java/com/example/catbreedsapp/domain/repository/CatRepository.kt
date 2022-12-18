package com.example.catbreedsapp.domain.repository

import com.example.catbreedsapp.data.model.Cat
import com.example.catbreedsapp.data.model.CatDetails

interface CatRepository {
    suspend fun getCats(): List<Cat>?
    suspend fun getCatById(catId: String) : CatDetails
}