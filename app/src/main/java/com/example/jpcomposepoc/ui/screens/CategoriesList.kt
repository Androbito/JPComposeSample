package com.example.jpcomposepoc.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.jpcomposepoc.model.*

@Preview
@Composable
fun HomeScreen(openMeal: (Int, Int) -> Unit = { _: Int, _: Int -> }) {
    Column {
        TopAppBar(title = {
            Text(text = "List of meals")
        })
        val list = CategoriesDataSource.getCategories(context = LocalContext.current)
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        ) {
            list.forEach { item ->
                CategoryItem(item, openMeal)
            }
        }
    }
}



