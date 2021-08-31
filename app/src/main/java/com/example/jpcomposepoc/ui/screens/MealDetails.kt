package com.example.jpcomposepoc.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddChart
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jpcomposepoc.model.CategoriesDataSource
import com.example.jpcomposepoc.model.CategoriesDataSource.orderList


@Preview(showBackground = true)
@Composable
fun MealDetailsScreen(
    idCategory: Int = 1,
    mealId: Int = 1,
    navigateUp: () -> Unit = { },
    navigateToOrder: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        CategoriesDataSource.getCategoryByID(
                            LocalContext.current,
                            idCategory
                        ).catName
                    )
                },
                navigationIcon = {
                    IconButton(onClick = navigateUp) {
                        Icon(Icons.Rounded.ArrowBack, contentDescription = "Back")
                    }
                },
            )
        }

    ) {

        val meal = CategoriesDataSource.getSubCategoryByID(
            LocalContext.current, idCategory, mealId
        )
        Column(Modifier.padding(16.dp)) {
            NetworkImage(
                url = meal.mealImg,
                contentDescription = meal.mealName,
                modifier = Modifier
                    .size(size = 100.dp)
                    .padding(8.dp)
                    .align(CenterHorizontally)
            )
            Text(
                fontSize = 30.sp,
                text = meal.mealName,
                modifier = Modifier.align(CenterHorizontally)
            )
            Divider(color = Color.Black, thickness = 1.dp)
            Text(text = meal.mealDetails, modifier = Modifier.padding(16.dp))
            Button(
                onClick = navigateToOrder.also {
                    if (!orderList.contains(meal))
                        orderList.add(meal)
                }, modifier = Modifier
                    .padding(8.dp)
                    .align(CenterHorizontally)
            ) {
                Row {
                    Icon(
                        imageVector = Icons.Default.AddShoppingCart,
                        contentDescription = null,
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Text(text = "Add")
                }
            }
        }
    }
}