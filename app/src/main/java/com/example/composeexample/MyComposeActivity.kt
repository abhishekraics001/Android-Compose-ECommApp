package com.example.composeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeexample.theme.MySystemTestTheme

class MyComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()

        setContent {


            MyContent()
        }
    }
}

@Composable
fun MyContent(){
    MySystemTestTheme {
        val navController = rememberNavController()
        Scaffold(
            //containerColor = Color.Red,
           /* contentColor = Color.White,
            containerColor = Color.White,*/
            modifier = Modifier.fillMaxSize(),
            topBar = {
                HeaderBar("My App Title x", 3)
            },
            bottomBar = {

                BottomNavigationBar(navController)

            }
        )  { innerPadding ->

           // DashBoardScreen(innerPadding)
            NavHost(navController,
                startDestination = "home",
                Modifier.padding(innerPadding)
            ) {

                composable("home") { HomeScreen(innerPadding) }
                composable("you") { YouScreen(innerPadding) }
                composable("more") { MoreScreen(innerPadding) }
                composable("cart") { CartScreen(innerPadding) }
                composable("menu") { MenuScreen(innerPadding) }
            }

        }
    }
}




@Preview(showBackground = true, showSystemUi = true, name = "My Compose Preview")
@Composable
fun GreetingPreview() {
    MyContent()
}










@Composable
fun PageHeadingText(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        style = MaterialTheme.typography.bodyLarge,
        color = Color.Black
    )
}































