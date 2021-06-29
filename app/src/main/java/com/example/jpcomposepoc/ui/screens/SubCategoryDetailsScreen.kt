package com.example.jpcomposepoc.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jpcomposepoc.loadNetworkImage
import com.example.jpcomposepoc.model.SubCategoriesSampleProvider
import com.example.jpcomposepoc.model.Subcategory

@Preview(showBackground = true)
@Composable
fun loadSubCategoryDetails(@PreviewParameter(SubCategoriesSampleProvider::class) subCategory: Subcategory) {
    Column(Modifier.padding(16.dp)) {
        loadNetworkImage(
            url = subCategory.subcatImg,
            contentDescription = subCategory.subcatName,
            modifier = Modifier
                .size(size = 100.dp)
                .padding(8.dp)
                .align(CenterHorizontally)
        )
        Text(fontSize = 30.sp, text = subCategory.subcatName,modifier = Modifier.align(CenterHorizontally))
        Divider(color = Color.Black, thickness = 1.dp)
        Text(text = subCategory.subcatDetails,modifier = Modifier.padding(16.dp))
        val context = LocalContext.current
        val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/")) }

        Button(modifier = Modifier.align(CenterHorizontally),onClick = { context.startActivity(intent) }) {
            Text(text = "Order")
        }
    }
}