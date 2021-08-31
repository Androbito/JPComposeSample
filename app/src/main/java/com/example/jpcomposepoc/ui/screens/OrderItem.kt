package com.example.jpcomposepoc.ui.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.jpcomposepoc.model.CategoriesDataSource
import com.example.jpcomposepoc.model.CategoriesDataSource.orderList
import com.example.jpcomposepoc.model.Meal
import com.example.jpcomposepoc.model.SubCategoriesSampleProvider


@Preview(showBackground = true)
@Composable
fun OrderItem(@PreviewParameter(SubCategoriesSampleProvider::class) meal: Meal) {
    Row {
        IconButton(
            onClick = {
                orderList.remove(meal)
            },
            modifier = Modifier.align(Alignment.CenterVertically),
        ) {
            Icon(
                Icons.Default.Clear,
                contentDescription = "Delete meal",
                tint = Color.Red
            )
        }
        Text(
            text = meal.mealName,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(8.dp, 0.dp, 0.dp, 0.dp)
                .weight(1f)
        )
        QuantityBlock()
    }
}