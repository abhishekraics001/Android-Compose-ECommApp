package com.example.composeexample

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun CartScreen(innerPadding: PaddingValues) {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.Red) {
        Text("Search Screen")
    }
}