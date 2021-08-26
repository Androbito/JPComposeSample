package com.example.jpcomposepoc.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter
import coil.compose.LocalImageLoader
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.jpcomposepoc.R

@Composable
fun NetworkImage(url: String, contentDescription: String, modifier: Modifier) {
    val painter = rememberImagePainter(
        data = url,
        imageLoader = LocalImageLoader.current,
        builder = {
            this.crossfade(true)
            placeholder(
                drawableResId = R.drawable.icon
            )
            transformations(CircleCropTransformation())
        }
    )

    Box(modifier = modifier) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            modifier = modifier
        )

        val state = painter.state
        if (state is ImagePainter.State.Loading) {
            // Display a circular progress indicator whilst loading
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }
        if (state is ImagePainter.State.Error) {
            // If you wish to display some content if the request fails
            Image(
                painter = painterResource(id = android.R.drawable.stat_notify_error),
                contentDescription = null // decorative element
            )
        }
    }
}

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
        }) {
            Text(
                text = "+"
            )
        }
    }

}