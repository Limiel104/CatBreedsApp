package com.example.catbreedsapp.domain.use_case

import com.example.catbreedsapp.data.model.CatDetails
import com.example.catbreedsapp.domain.repository.CatRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCatDetailsUseCase  @Inject constructor(private val catRepository: CatRepository) {

    //suspend fun execute(catId: String): CatDetails = catRepository.getCatById(catId)
    operator fun invoke(catId: String): Flow<CatDetails> = flow{
        val cats = catRepository.getCatById(catId)
    }
}