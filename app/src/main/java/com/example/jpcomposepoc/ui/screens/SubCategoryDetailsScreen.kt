package com.example.jpcomposepoc.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
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
        Text(
            fontSize = 30.sp,
            text = subCategory.subcatName,
            modifier = Modifier.align(CenterHorizontally)
        )
        Divider(color = Color.Black, thickness = 1.dp)
        Text(text = subCategory.subcatDetails, modifier = Modifier.padding(16.dp))
        val context = LocalContext.current
        val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/")) }
        QuantityBlock()
        Button(
            modifier = Modifier.align(CenterHorizontally),
            onClick = { context.startActivity(intent) }) {
            Text(text = "Order")
        }
    }
}

data class QuantityState(
    val quantity: String,
    val minusDisabled: Boolean,
    val moreDisabled: Boolean
)

@Preview(showBackground = true)
@Composable
fun QuantityBlock() {
    Row(
        modifier = Modifier
            .padding(16.dp)
    ) {
        var quantity by remember { mutableStateOf(0) }
        Button(modifier = Modifier
            .padding(16.dp)
            .weight(0.2f)
            .align(Alignment.CenterVertically), onClick = {
            if (quantity > 0) {
                quantity--
            }
        }) { Text(text = "-") }
        OutlinedTextField(modifier = Modifier
            .align(Alignment.CenterVertically)
            .weight(0.6f),
            value = "$quantity",
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            onValueChange = {
                quantity = if (it.isNotBlank()) it.toInt() else 0
            })
        Button(modifier = Modifier
            .padding(16.dp)
            .weight(0.2f)
            .align(Alignment.CenterVertically), onClick = {
            if (quantity < 99) {
                quantity++
            }
        }) { Text(text = "+") }
    }

}