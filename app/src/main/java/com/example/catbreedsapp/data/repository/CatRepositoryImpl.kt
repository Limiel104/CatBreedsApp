package com.example.catbreedsapp.data.repository

import com.example.catbreedsapp.data.api.TheCatApi
import com.example.catbreedsapp.data.model.Cat
import com.example.catbreedsapp.data.model.CatDetails
import com.example.catbreedsapp.domain.repository.CatRepository
import javax.inject.Inject

class CatRepositoryImpl @Inject constructor(private  val api: TheCatApi) : CatRepository{
    override suspend fun getCats(): List<Cat>? {
        return api.getCats()
    }

    override suspend fun getCatById(catId: String): CatDetails {
        return api.getCatById(catId)
    }
}