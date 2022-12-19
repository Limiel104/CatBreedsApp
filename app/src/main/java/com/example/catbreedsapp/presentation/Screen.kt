package com.example.catbreedsapp.presentation

sealed class Screen(val route: String){
    object CayListScreen: Screen("cat_list_screen")
    object CayDetailsScreen: Screen("cat_details_screen")
}
