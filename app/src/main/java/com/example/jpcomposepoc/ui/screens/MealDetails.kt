package com.example.jpcomposepoc.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jpcomposepoc.model.CategoriesDataSource
import com.example.jpcomposepoc.model.SubCategoriesSampleProvider
import com.example.jpcomposepoc.model.Meal


@Preview(showBackground = true)
@Composable
fun MealDetailsScreen(idCategory: Int = 1, mealId: Int = 1, navigateUp: (() -> Unit)? = null) {
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
                    navigateUp?.let {
                        IconButton(onClick = it) {
                            Icon(Icons.Rounded.ArrowBack, contentDescription = "Back")
                        }
                    }
                },
            )
        }

    ) {

        val subCategory = CategoriesDataSource.getSubCategoryByID(
            LocalContext.current, idCategory, mealId
        )
        Column(Modifier.padding(16.dp)) {
            NetworkImage(
                url = subCategory.mealImg,
                contentDescription = subCategory.subcatName,
                modifier = Modifier
                    .size(size = 100.dp)
                    .padding(8.dp)
                    .align(CenterHorizontally)
            )
            Text(
                fontSize = 30.sp,
                text = subCategory.subcatName,
                modifier = Modifier.align(CenterHorizontally)
            )
            Divider(color = Color.Black, thickness = 1.dp)
            Text(text = subCategory.mealDetails, modifier = Modifier.padding(16.dp))
            val context = LocalContext.current
            val intent =
                remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/")) }
            QuantityBlock()
            Button(
                modifier = Modifier.align(CenterHorizontally),
                onClick = { context.startActivity(intent) }) {
                Text(text = "Order")
            }
        }
    }
}