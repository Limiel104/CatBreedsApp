package com.example.catbreedsapp.data.api

import com.example.catbreedsapp.data.model.Cat
import com.example.catbreedsapp.data.model.CatDetails
import retrofit2.http.GET
import retrofit2.http.Path

interface TheCatApi {

    @GET("/v1/breeds")
    suspend fun getCats(): List<Cat>

    @GET("/v1/breeds/{catId}")
    suspend fun getCatById(@Path("catId") catId: String): CatDetails

}