package com.example.jpcomposepoc

import androidx.navigation.NavHostController
import com.example.jpcomposepoc.Destinations.MealDetails

object Destinations {
    const val Home = "home"
    const val MealDetails = "mealDetails"

    object MealDetailsArgs {
        const val CategoryId = "categoryId"
        const val MealId = "mealId"
    }
}

class Actions(navController: NavHostController) {
    val openMeal: (Int,Int) -> Unit = { categoryId,mealId ->
        navController.navigate("$MealDetails/$categoryId/$mealId")
    }

    val navigateUp: () -> Unit = {
        navController.popBackStack()
    }
}