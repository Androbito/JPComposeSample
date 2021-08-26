package com.example.jpcomposepoc.model

import com.google.gson.annotations.SerializedName

data class CategoryItem(
    @SerializedName("cat_name")
    val catName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("cat_img")
    val catImg: String,
    @SerializedName("subcategories")
    val meals: List<Meal>
)

data class Meal(
    @SerializedName("id")
    val id: Int,
    @SerializedName("subcat_img")
    val mealImg: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("subcat_details")
    val mealDetails: String,
    @SerializedName("subcat_name")
    val subcatName: String
)