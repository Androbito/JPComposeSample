package com.example.jpcomposepoc

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.example.jpcomposepoc.model.CategoriesDataSource
import com.example.jpcomposepoc.model.Subcategory
import com.example.jpcomposepoc.ui.theme.JPComposePOCTheme

const val CATEGORY_ID = "Category_ID"
const val SUBCATEGORY_ID = "SubCategory_ID"

class DetailsActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JPComposePOCTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    UIDetails(
                        intent.getIntExtra(CATEGORY_ID, -1),
                        intent.getIntExtra(SUBCATEGORY_ID, -1)
                    )
                }
            }
        }
    }


    companion object {
        fun newIntent(context: Context, categoryID: Int, subcategoryID: Int) =
            Intent(context, DetailsActivity::class.java).apply {
                putExtra(CATEGORY_ID, categoryID)
                putExtra(SUBCATEGORY_ID, subcategoryID)
            }
    }


}

@Preview(showBackground = true)
@Composable
fun UIDetails(idCategory: Int =1, idSubCategory: Int =1) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Meal details") })
        }
    ) {
        loadSubCategoryDetails(
            subCategory = CategoriesDataSource.getSubCategoryByID(
                LocalContext.current, idCategory, idSubCategory
            )
        )
    }
}




