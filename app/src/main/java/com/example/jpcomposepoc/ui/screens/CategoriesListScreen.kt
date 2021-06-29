package com.example.jpcomposepoc

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.transform.CircleCropTransformation
import com.example.jpcomposepoc.model.*
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.imageloading.ImageLoadState

@Composable
fun loadCategoriesListScreen(goToDetails: (Int, Int) -> Unit) {
    Column {
        TopAppBar(title = {
            Text(text = "List of meals")
        })
        val list = CategoriesDataSource.getCategories(context = LocalContext.current)
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        ) {
            list.forEach {
                displayCategoryItem(it, goToDetails)
            }
        }
    }
}

@Preview
@Composable
fun displayCategoryItem(
    @PreviewParameter(CategoriesSampleProvider::class) category: CategoryItem,
    goToDetails: ((Int, Int) -> Unit)? = null
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp)
            ) {
                //loadCategoryImage(category)
                loadNetworkImage(
                    category.catImg, category.catName, Modifier
                        .size(size = 80.dp)
                        .padding(8.dp)
                )
                Text(
                    text = category.catName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(CenterVertically)
                        .padding(8.dp),
                    fontSize = 30.sp
                )
            }
            category.subcategories.forEach { subCategory ->
                displaySubCategoryItem(subCategory) {
                    goToDetails?.let { it(category.id, subCategory.id) }
                    Log.i("displaySubCategoryItem", "${category.id}/${subCategory.id}")
                }
            }
        }
    }
}

@Composable
fun loadNetworkImage(url: String, contentDescription: String, modifier: Modifier) {
    val painter = rememberCoilPainter(
        request = url,
        requestBuilder = {
            transformations(CircleCropTransformation())
        },previewPlaceholder = R.drawable.icon
    )

    Box(modifier = modifier) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            modifier = modifier
        )

        when (painter.loadState) {
            is ImageLoadState.Loading -> {
                // Display a circular progress indicator whilst loading
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
            is ImageLoadState.Error -> {
                // If you wish to display some content if the request fails
                Image(
                    painter = painterResource(id = android.R.drawable.stat_notify_error),
                    contentDescription = null // decorative element
                )
            }
        }
    }
}


@Composable
fun displaySubCategoryItem(
    @PreviewParameter(SubCategoriesSampleProvider::class) subCategory: Subcategory,
    navigateToDetails: () -> Unit
) {
    Column {
        Divider(color = Color.Black, thickness = 1.dp)
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .clickable(enabled = true, onClick = navigateToDetails)
        ) {
            loadNetworkImage(
                subCategory.subcatImg, subCategory.subcatName, Modifier
                    .size(size = 40.dp)
            )
            Text(
                text = subCategory.subcatName,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .align(CenterVertically)
                    .padding(8.dp,0.dp)
            )
            Text(
                text = "${subCategory.price} MAD", style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Right
                ), modifier = Modifier
                    .fillMaxWidth()
                    .align(CenterVertically)
            )
        }

    }
}