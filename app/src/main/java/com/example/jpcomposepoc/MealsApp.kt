package com.example.jpcomposepoc

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.jpcomposepoc.Destinations.Home
import com.example.jpcomposepoc.Destinations.MealDetails
import com.example.jpcomposepoc.Destinations.MealDetailsArgs.CategoryId
import com.example.jpcomposepoc.Destinations.MealDetailsArgs.MealId
import com.example.jpcomposepoc.Destinations.OrderDetails
import com.example.jpcomposepoc.ui.screens.HomeScreen
import com.example.jpcomposepoc.ui.screens.MealDetailsScreen
import com.example.jpcomposepoc.ui.screens.OrderDetailsScreen


@Composable
fun MealsApp() {
    val navController = rememberNavController()
    val actions = remember(navController) { Actions(navController) }
    NavHost(navController, startDestination = Home) {
        composable(Home) {
            HomeScreen(actions.openMeal)
        }
        composable(
            "$MealDetails/{$CategoryId}/{$MealId}",
            arguments = listOf(
                navArgument(CategoryId) { type = NavType.IntType },
                navArgument(MealId) { type = NavType.IntType })
        ) { navBackStackEntry ->
            MealDetailsScreen(
                idCategory = navBackStackEntry.arguments?.getInt(CategoryId) ?: 1,
                mealId = navBackStackEntry.arguments?.getInt(MealId) ?: 1,
                navigateUp = actions.navigateUp,
                navigateToOrder = actions.openOrder
            )
        }
        composable(OrderDetails){
            OrderDetailsScreen(backHome = actions.backHome)
        }
    }
}