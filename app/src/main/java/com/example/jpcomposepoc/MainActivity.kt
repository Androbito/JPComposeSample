package com.example.jpcomposepoc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jpcomposepoc.ui.theme.JPComposePOCTheme


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JPComposePOCTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    UIApp { idCategory: Int, idSubCategory: Int ->
                        startActivity(
                            DetailsActivity.newIntent(
                                this@MainActivity,
                                idCategory,
                                idSubCategory
                            )
                        )

                    }
                }
            }
        }
    }
}

@Composable
fun UIApp(goToDetails: (Int, Int) -> Unit) {
    loadCategoriesListScreen(goToDetails)

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JPComposePOCTheme {
        UIApp { i, i2 ->
            Unit
        }
    }
}

