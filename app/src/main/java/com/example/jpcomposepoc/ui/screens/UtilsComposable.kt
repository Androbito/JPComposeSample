package com.example.jpcomposepoc.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter
import coil.compose.LocalImageLoader
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.jpcomposepoc.R
import com.example.jpcomposepoc.ui.theme.Purple500

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
                contentDescription = "Error loading image" // decorative element
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
            .width(150.dp)
    ) {
        var quantity = 1
        IconButton(
            onClick = {
                if (quantity > 1) {
                    quantity--
                }
            },
            modifier = Modifier
                .size(40.dp)
                .border(1.dp, Purple500, shape = CircleShape)
                .align(Alignment.CenterVertically)
                .padding(8.dp)
        ) {
            Icon(Icons.Default.Remove, contentDescription = "content description", tint = Purple500)
        }
        Spacer(modifier = Modifier.size(5.dp))
        OutlinedTextField(
            enabled = false,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                disabledTextColor = LocalContentColor.current.copy(LocalContentAlpha.current),
                disabledBorderColor = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled),
                disabledLabelColor = MaterialTheme.colors.onSurface.copy(ContentAlpha.medium)
            ),
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(1f)
                .border(1.dp, Purple500, shape = RoundedCornerShape(5.dp)),
            value = "$quantity",
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            onValueChange = {
                quantity = if (it.isNotBlank()) it.toInt() else 0
            },
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
        )
        Spacer(modifier = Modifier.size(5.dp))
        IconButton(
            onClick = {
                if (quantity < 99) {
                    quantity++
                }
            },
            modifier = Modifier
                .size(40.dp)
                .border(1.dp, Purple500, shape = CircleShape)
                .align(Alignment.CenterVertically)
                .padding(8.dp)
        ) {
            Icon(Icons.Default.Add, contentDescription = "content description", tint = Purple500)
        }
    }

}