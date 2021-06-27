package com.example.jpcomposepoc.model

import android.content.Context
import com.example.jpcomposepoc.getJsonDataFromAssetFileName
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken

data class CategoryItem(
    @SerializedName("cat_name")
    val catName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("cat_img")
    val catImg: String,
    @SerializedName("subcategories")
    val subcategories: List<Subcategory>
)

data class Subcategory(
    @SerializedName("id")
    val id: Int,
    @SerializedName("subcat_img")
    val subcatImg: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("subcat_details")
    val subcatDetails: String,
    @SerializedName("subcat_name")
    val subcatName: String
)