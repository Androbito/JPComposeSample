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
                MealsApp()
            }
            //helloContent()
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        JPComposePOCTheme {
            MealsApp()
        }
    }

}

