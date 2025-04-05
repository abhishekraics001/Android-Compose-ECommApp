package com.example.composeexample

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(innerPadding: PaddingValues) {


    // Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
    //Text("Home Screen")
    DashBoardScreen(innerPadding);
    // }
}