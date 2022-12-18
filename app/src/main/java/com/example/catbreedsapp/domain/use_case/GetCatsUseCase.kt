package com.example.catbreedsapp.domain.use_case

import com.example.catbreedsapp.data.model.Cat
import com.example.catbreedsapp.domain.repository.CatRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCatsUseCase @Inject constructor(private val catRepository: CatRepository) {

    //suspend fun execute(): List<Cat>? = catRepository.getCats()
    operator fun invoke(): Flow<List<Cat>> = flow{
        val cats = catRepository.getCats()
    }
}