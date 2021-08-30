package com.example.jpcomposepoc.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jpcomposepoc.model.CategoriesSampleProvider
import com.example.jpcomposepoc.model.CategoryItem

@Preview
@Composable
fun CategoryItem(
    @PreviewParameter(CategoriesSampleProvider::class) category: CategoryItem,
    goToDetails: (Int, Int) -> Unit = { _: Int, _: Int -> }
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp)
            ) {
                //loadCategoryImage(category)
                NetworkImage(
                    category.catImg, category.catName, Modifier
                        .size(size = 80.dp)
                        .padding(8.dp)
                )
                Text(
                    text = category.catName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                        .padding(8.dp),
                    fontSize = 30.sp
                )
            }
            category.meals.forEach { subCategory ->

                MealItem(category, subCategory, goToDetails)

            }
        }
    }
}



