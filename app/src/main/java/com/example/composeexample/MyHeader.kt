package com.example.composeexample

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mysystemtest.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderBar(title: String, itemCount: Int) {
    TopAppBar(
        title = {
            Column {
                Text(
                    text = "Del's in 8 minutes",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W800),
                    color = Color.White,
                    fontSize = 24.sp,
                    letterSpacing = 1.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Home: 2nd Floor, 789 Main Street, ECity, 123456",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.W400),
                    color = Color.White,
                    fontSize = 12.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

        },

        actions = {
            Box(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .size(40.dp),
                contentAlignment = Alignment.Center
            ) {
                IconButton(onClick = {
                    /* Handle cart click */
                }) {
                    Image(
                        painter = painterResource(id = R.drawable.shoping_cart), // Replace with your cart icon
                        contentDescription = "Cart",
                        modifier = Modifier.size(24.dp)
                    )
                }
                if (itemCount > 0) {
                    Badge(
                        count = itemCount,
                        modifier = Modifier.align(Alignment.TopEnd)
                    )
                }
            }
        },
        colors = topAppBarColors(
            containerColor = Color(0xFFccad00), //MaterialTheme.colorScheme.primary,
            //navigationIconContentColor = MaterialTheme.colorScheme.primary,
            titleContentColor = Color.White,
            actionIconContentColor = Color(0xFFccad00)
        ),

        )
}

@Composable
fun Badge(count: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(24.dp)
            .padding(4.dp)
            .background(Color.Red, shape = MaterialTheme.shapes.small),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = count.toString(),
            color = Color.White,
            fontWeight = FontWeight.Normal, // Use Bold for better visibility
            fontSize = 10.sp, // Adjust font size as needed
            style = MaterialTheme.typography.bodySmall, // Use a suitable typography style
            textAlign = TextAlign.Center // Center the text
        )
    }
}