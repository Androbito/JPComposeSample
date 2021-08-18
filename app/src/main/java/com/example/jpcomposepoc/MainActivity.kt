package com.example.jpcomposepoc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.jpcomposepoc.ui.screens.helloContent
import com.example.jpcomposepoc.ui.theme.JPComposePOCTheme


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainLayout()
            //helloContent()
        }
    }

    @Composable
    private fun MainLayout() {
        JPComposePOCTheme {
            // A surface container using the 'background' color from the theme
            Surface(color = MaterialTheme.colors.background) {
                loadCategoriesListScreen { idCategory: Int, idSubCategory: Int ->
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


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        JPComposePOCTheme {
            MainLayout()
        }
    }

}
