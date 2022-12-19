package com.example.catbreedsapp.presentation.cat_list.composables

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.catbreedsapp.presentation.Screen
import com.example.catbreedsapp.presentation.cat_list.CatListViewModel

@Composable
fun CatListScreen(
    navController: NavController,
    viewModel: CatListViewModel = hiltViewModel()
){
    val state = viewModel.state.value

    Box(
        modifier = Modifier.fillMaxSize()
    ){
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.cats){ cat ->
                CatListItem(
                    cat = cat,
                    onItemClick = {
                        navController.navigate(Screen.CayDetailsScreen.route + "/${cat.id}")
                        Log.i("TAG",cat.name + "  " + cat.countryCode)
                })
            }
        }
    }
}