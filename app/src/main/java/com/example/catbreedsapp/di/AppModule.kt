package com.example.catbreedsapp.di

import com.example.catbreedsapp.data.api.TheCatApi
import com.example.catbreedsapp.data.repository.CatRepositoryImpl
import com.example.catbreedsapp.domain.repository.CatRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideApi(): TheCatApi {
        return Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TheCatApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCatRepository(api: TheCatApi): CatRepository{
        return CatRepositoryImpl(api)
    }
}