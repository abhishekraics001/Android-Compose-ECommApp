package com.example.composeexample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SearchViewDesign() {
    val searchQuery = remember { mutableStateOf("") }

    Column(

        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(1.dp)




    ) {
        // Search Box
        SearchBox(
            searchQuery = searchQuery.value,
            onQueryChange = { searchQuery.value = it }
        )

      //  Spacer(modifier = Modifier.height(2.dp))

        // Content based on search query
        //SearchContent(searchQuery = searchQuery.value)
    }
}

@Composable
fun SearchBox(searchQuery: String, onQueryChange: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFFDDDBDB),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Search Icon
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search Icon",
            modifier = Modifier.size(24.dp),
            tint = Color.Gray
        )

        Spacer(modifier = Modifier.width(5.dp))

        // Search TextField
        BasicTextField(
            value = searchQuery,
            onValueChange = onQueryChange,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            textStyle = TextStyle(fontSize = 18.sp),
            decorationBox = { innerTextField ->
                if (searchQuery.isEmpty()) {
                    Text(
                        text = "Search...",
                        style = TextStyle(color = Color.Gray, fontSize = 18.sp)
                    )
                }
                innerTextField()
            }
        )
    }
}

@Composable
fun SearchContent(searchQuery: String) {
    if (searchQuery.isEmpty()) {
        Text(text = "Type something to search...", fontSize = 14.sp, color = Color.Black)
    } else {
        Text(text = "Results for \"$searchQuery\":", fontSize = 14.sp, color = Color.Black)
        // Display filtered content based on search query (e.g., a list of items)
    }
}