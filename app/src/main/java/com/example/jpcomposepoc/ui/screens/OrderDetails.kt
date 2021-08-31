package com.example.jpcomposepoc.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jpcomposepoc.model.CategoriesDataSource.orderList
import com.example.jpcomposepoc.ui.theme.JPComposePOCTheme


@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
fun OrderDetailsScreen(backHome: () -> Unit = {}) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Your Order"
                    )
                },
                navigationIcon = {
                    IconButton(onClick = backHome) {
                        Icon(Icons.Rounded.ArrowBack, contentDescription = "Back")
                    }
                })
        }
    ) {
        AnimatedVisibility(visible = orderList.isEmpty()) {
            Text(
                text = "No order in your cart",
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.h4
            )
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()

        ) {
            items(orderList) {
                OrderItem(it)
            }
        }
    }
}
