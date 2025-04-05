package com.example.composeexample

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mysystemtest.R


@Composable
fun ItemsListLazyColumn(modifier: Modifier = Modifier) {
    // A surface container using the 'background' color from the theme
    LazyColumn(modifier = modifier
        .padding(2.dp)
        //.fillMaxSize()
        //.wrapContentHeight(), // Apply padding to avoid overlapping
        .fillMaxWidth()
        .height(200.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    )
    {
        items(3) { index ->
            //Text("Item $it", fontSize = 24.sp, modifier = Modifier.padding(10.dp))
            ListItemsRowViewCustomCard(itemIndex = index)
        }
    }
}




@Composable
fun ListItemsRowViewCustomCard(itemIndex: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
 }
            .padding(2.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Add an optional image or icon (replace with your own resource)
            Image(
                painter = painterResource(id = R.drawable.people),
                contentDescription = "Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(58.dp)
                    .background(Color.Gray, shape = RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(10.dp))

            // Item text content
            Column {
                Text(
                    text = "Item #$itemIndex",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "Description for item #$itemIndex",
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }
        }
    }
}
