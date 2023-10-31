package com.theandroidmate.completeguide.ui.component

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun ComposableApp() {
    val navController = rememberNavController()
    ComposableNavHost(
        navController = navController
    )
}

@Composable
fun ComposableNavHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home"){
//            navController.navigate("detail/123")
        }
        composable(
            "detail/{newId}",
            arguments = listOf(navArgument("newId") {
                type = NavType.StringType
            },
                )
        ){
            it.arguments?.getString("newId")
        }
    }
}