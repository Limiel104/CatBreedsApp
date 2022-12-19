package com.example.catbreedsapp.presentation.cat_details.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.catbreedsapp.presentation.cat_details.CatDetailsViewModel

@Composable
fun CatDetailsScreen(
    viewModel: CatDetailsViewModel = hiltViewModel()
){
    val state = viewModel.state.value

    Box(
        modifier = Modifier.fillMaxSize()
    ){
        state.cat?.let { cat ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = cat.name
                )
            }
        }
    }
}