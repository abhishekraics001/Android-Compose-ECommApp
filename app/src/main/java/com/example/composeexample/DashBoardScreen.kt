package com.example.composeexample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DashBoardScreen(innerPadding: PaddingValues) {


    LazyColumn(
        modifier = Modifier
            .padding(all = 5.dp)
            .fillMaxSize() // Fill the entire size of the screen
            // .padding(innerPadding),
            // contentPadding = PaddingValues(2.dp),
            //verticalArrangement = Arrangement.spacedBy(1.dp) // Adds space between items
            .background(Color(0xFFfff))
    ) {

        // Greeting section
        /* item {
             PageHeadingText(
                 name = ": My Items List",
                 modifier = Modifier.padding(15.dp) // Padding for Greeting content
             )
         }*/



        // Search Box section
        item {

            SearchViewDesign()
        }


        // LazyRow section (set an explicit height to avoid infinite height issues)
        item {
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Top Category",
                fontSize = 16.sp, // Text size
                fontWeight = FontWeight.Bold,
                color = Color(0xFF000000), //MaterialTheme.colorScheme.onBackground // Text color
            )
            CategoryListLazyRow() // Set height for the LazyRow
        }



        // Carousel section
        item {
            Box(modifier = Modifier
                .fillMaxWidth()
                //.height(200.dp)
                .height(210.dp)
                .background(Color.White)
            ) {
                CarouselScreen()
            }
        }





        // LazyVerticalGrid section (set a fixed height for the grid)
        item {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Shop By Category",
                fontSize = 16.sp, // Text size
                fontWeight = FontWeight.Bold,
                color = Color(0xFF000000), //MaterialTheme.colorScheme.onBackground // Text color
            )
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(640.dp)) { // Use a Box to restrict height
                GridItemsLazyVerticalGrid4()
            }
        }



        // LazyVerticalGrid section (set a fixed height for the grid)
        item {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Trending Products",
                fontSize = 16.sp, // Text size
                fontWeight = FontWeight.Bold,
                color = Color(0xFF000000), //MaterialTheme.colorScheme.onBackground // Text color
            )
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(600.dp)) { // Use a Box to restrict height
                ProductGridItems2()
            }
        }


        // LazyColumn ListView section
        item {
            ItemsListLazyColumn(Modifier.height(220.dp))
        }


    }
}