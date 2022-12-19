package com.example.catbreedsapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.catbreedsapp.presentation.cat_details.composables.CatDetailsScreen
import com.example.catbreedsapp.presentation.cat_list.composables.CatListScreen
import com.example.catbreedsapp.presentation.ui.theme.CatBreedsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatBreedsAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CayListScreen.route
                    ){
                        composable(
                            route = Screen.CayListScreen.route
                        ){
                            CatListScreen(navController)
                        }
                        composable(
                            route = Screen.CayDetailsScreen.route + "/{catId}"
                        ){
                            CatDetailsScreen()
                        }
                    }
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    CatBreedsAppTheme {
//        Greeting("Android")
//    }
//}