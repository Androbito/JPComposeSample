package com.example.jpcomposepoc

import android.content.Context
import java.io.IOException


fun Context.calculateNoOfColumns(
    columnWidthDp: Float
): Int {
    val displayMetrics = this.resources.displayMetrics
    val screenWidthDp = displayMetrics.widthPixels / displayMetrics.density
    return (screenWidthDp / columnWidthDp + 0.5).toInt()
}

fun String.getJsonDataFromAssetFileName(context: Context): String? {
    val jsonString: String
    try {
        jsonString = context.assets.open(this).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return jsonString
}

