package com.example.jpcomposepoc.model

import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.datasource.CollectionPreviewParameterProvider
import com.example.jpcomposepoc.getJsonDataFromAssetFileName
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object CategoriesDataSource {

    var orderList = mutableStateListOf<Meal>()

    fun getCategories(context: Context): List<CategoryItem> {
        val gson = Gson()
        val listPersonType = object : TypeToken<List<CategoryItem>>() {}.type
        val jsonFileString = "data.json".getJsonDataFromAssetFileName(context)
        return gson.fromJson(jsonFileString, listPersonType)
    }

    fun getCategoryByID(context: Context, id: Int): CategoryItem {
        return getCategories(context = context).single { it.id == id }
    }

    fun getSubCategoryByID(context: Context, idCategory: Int, idSubCategory: Int): Meal {
        return getCategoryByID(
            context = context,
            idCategory
        ).meals.single { it.id == idSubCategory }
    }
}


class CategoriesSampleProvider : CollectionPreviewParameterProvider<CategoryItem>(
    listOf(
        CategoryItem("Tacos", 1, "https://picsum.photos/300/300", emptyList()),
        CategoryItem(
            "Coffee",
            2,
            "https://picsum.photos/300/300",
            listOf(
                Meal(
                    1,
                    "https://picsum.photos/300/300",
                    40,
                    "Coffee with milk",
                    "Coffee Late"
                )
            )
        )
    )
)

class SubCategoriesSampleProvider : CollectionPreviewParameterProvider<Meal>(
    listOf(
        Meal(1, "https://picsum.photos/300/300", 40, "Coffee with milk", "Coffee Late")
    )
)
