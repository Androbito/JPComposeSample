package com.example.jpcomposepoc

import androidx.navigation.NavHostController
import com.example.jpcomposepoc.Destinations.Home
import com.example.jpcomposepoc.Destinations.MealDetails
import com.example.jpcomposepoc.Destinations.OrderDetails

object Destinations {
    const val Home = "home"
    const val MealDetails = "mealDetails"
    const val OrderDetails = "orderDetails"

    object MealDetailsArgs {
        const val CategoryId = "categoryId"
        const val MealId = "mealId"
    }
}

class Actions(navController: NavHostController) {
    val openMeal: (Int,Int) -> Unit = { categoryId,mealId ->
        navController.navigate("$MealDetails/$categoryId/$mealId")
    }

    val openOrder:() -> Unit = {
        navController.navigate("$OrderDetails")
    }

    val backHome: () -> Unit = {
        navController.popBackStack(route= "$Home", inclusive = false)
    }

    val navigateUp: () -> Unit = {
        navController.popBackStack()
    }
}