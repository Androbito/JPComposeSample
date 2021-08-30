package com.example.jpcomposepoc.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.jpcomposepoc.model.CategoriesSampleProvider
import com.example.jpcomposepoc.model.CategoryItem
import com.example.jpcomposepoc.model.Meal
import com.example.jpcomposepoc.model.SubCategoriesSampleProvider


@Composable
fun MealItem(
    @PreviewParameter(CategoriesSampleProvider::class) category: CategoryItem,
    @PreviewParameter(SubCategoriesSampleProvider::class) subCategory: Meal,
    navigateToDetails: (Int, Int) -> Unit
) {
    Column {
        Divider(color = Color.Black, thickness = 1.dp)
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .clickable(
                    enabled = true,
                    onClick = { navigateToDetails(category.id, subCategory.id) }
                )
        ) {
            NetworkImage(
                subCategory.mealImg, subCategory.mealName, Modifier
                    .size(size = 40.dp)
            )
            Text(
                text = subCategory.mealName,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .align(Alignment.CenterVertically)
                    .padding(8.dp, 0.dp)
            )
            Text(
                text = "${subCategory.price/10f} $", style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Right
                ), modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            )
        }

    }
}