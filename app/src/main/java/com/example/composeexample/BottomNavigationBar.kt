package com.example.composeexample

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun BottomNavigationBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    BottomNavigation(
        backgroundColor = Color(0xFFccad00), // Customize background color
        contentColor = Color.White,
        elevation = 8.dp,
        modifier = Modifier.padding(0.dp)
    ) {
        NavigationItems.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                icon = {
                    NavigationIcon(item.icon(), currentRoute == item.route, item.route, currentRoute)
                   /* Icon(
                        imageVector = item.icon(),
                        contentDescription = null,
                        modifier = Modifier.size(if (currentRoute == item.route) 28.dp else 22.dp),
                        tint = if (currentRoute == item.route) Color.White else Color.Gray // Tint based on selection
                    )*/
                },
                label = {
                    NavigationLabel(item.route, currentRoute)
                },
                onClick = {
                    navController.navigate(item.route) {
                        // Optional: Configure navigation logic
                        popUpTo(navController.graph.startDestinationId) { // or your own destination
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun NavigationLabel(route: String, currentRoute: String?) {
    val isSelected = route == currentRoute
    Text(
        text = route.capitalize(), // Capitalize for better readability
        color = if (isSelected) Color.White else Color.Gray, // Change text color based on selection
        fontSize = if (isSelected) 16.sp else 12.sp,
        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Thin
    )
}

@Composable
fun NavigationIcon(icon: ImageVector, isSelected: Boolean, route: String, currentRoute: String?) {
    //val isSelected = route == currentRoute
   return Icon(
        imageVector = icon,
        contentDescription = null,
        modifier = Modifier.size(if(isSelected) 28.dp else 22.dp),
        tint = if (currentRoute == route) Color.White else Color.Gray // Tint based on selection
    )
   /* Icon(
        imageVector = item.icon(),
        contentDescription = null,
        modifier = Modifier.size(if (currentRoute == item.route) 28.dp else 22.dp),
        tint = if (currentRoute == item.route) Color.White else Color.Gray // Tint based on selection
    )*/
}

// Data class for navigation items
data class NavigationItem(val route: String, val icon: () -> ImageVector)

// List of navigation items with customizable icons
private val NavigationItems = listOf(
    NavigationItem("home") { Icons.Filled.Home },
    NavigationItem("you") { Icons.Filled.AccountCircle },
    NavigationItem("cart") { Icons.Filled.ShoppingCart },
    NavigationItem("more") { Icons.Filled.Star},
    NavigationItem("Menu") { Icons.Filled.Menu },
)






@Composable
fun BottomNavigationBarOld(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    BottomNavigation(
        backgroundColor = Color(0xFFccad00), // Change this to your desired color
        contentColor = Color.White,
        elevation = 8.dp,
        modifier = Modifier.padding(0.dp)

    ) {

        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = null) },
            label = {
                Text("Home",
                    color = if (currentRoute == "home") Color.White else Color.Gray,
                    fontSize = if (currentRoute == "home") 16.sp else 14.sp,
                    fontWeight = if (currentRoute == "home") FontWeight.Bold else FontWeight.Normal
                )
            },
            selected = currentRoute == "home",
            onClick = {
                navController.navigate("home") {
                    /* popUpTo("home") {
                         saveState = true
                     }
                     launchSingleTop = true
                     restoreState = true*/
                }
            }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.AccountCircle, contentDescription = null) },
            label = {
                Text("You",
                    color = if (currentRoute == "you") Color.White else Color.Gray,
                    fontSize = if (currentRoute == "you") 16.sp else 14.sp,
                    fontWeight = if (currentRoute == "you") FontWeight.Bold else FontWeight.Normal
                )
            },

            selected = currentRoute == "you",
            onClick = {
                navController.navigate("you") {
                    /* popUpTo("you") {
                         saveState = true
                     }
                     launchSingleTop = true
                     restoreState = true*/
                }
            }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Star, contentDescription = null) },
            label = {
                Text("More",
                    color = if (currentRoute == "more") Color.White else Color.Gray,
                    fontSize = if (currentRoute == "more") 16.sp else 14.sp,
                    fontWeight = if (currentRoute == "more") FontWeight.Bold else FontWeight.Normal
                )
            },
            selected = currentRoute == "more",
            onClick = {
                navController.navigate("more") {
                    /* popUpTo("more"){
                         saveState = true
                     }
                     launchSingleTop = true
                     restoreState = true*/
                }
            }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.ShoppingCart, contentDescription = null) },
            label = { Text("Cart",
                color = if (currentRoute == "cart") Color.White else Color.Gray,
                fontSize = if (currentRoute == "cart") 16.sp else 14.sp,
                fontWeight = if (currentRoute == "cart") FontWeight.Bold else FontWeight.Normal
            )
            },
            selected = currentRoute == "cart",
            onClick = {
                navController.navigate("cart"){
                    /* popUpTo("cart") { saveState = true }
                     launchSingleTop = true
                     restoreState = true*/
                }
            },
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Menu, contentDescription = null) },
            label = { Text("Menu",
                color = if (currentRoute == "menu") Color.White else Color.Gray,
                fontSize = if (currentRoute == "menu") 16.sp else 14.sp,
                fontWeight = if (currentRoute == "menu") FontWeight.Bold else FontWeight.Normal
            )
            },
            selected = currentRoute == "menu",
            onClick = {
                navController.navigate("menu") {
                    /*  popUpTo("menu") { saveState = true }
                      launchSingleTop = true
                      restoreState = true*/
                }
            },
        )
    }
}