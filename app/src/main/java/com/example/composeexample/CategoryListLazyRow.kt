package com.example.composeexample

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.compose.animation.core.Transition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.example.mysystemtest.R


data class categoryList(val name: String, val icon: Int, var imageURL: String)
var categoryListItemsNew = mutableListOf<categoryList>().apply {
   // add(categoryList(name = "All", icon = R.drawable.people, imageURL = "https://instamart-media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_294/NI_CATALOG/IMAGES/CIW/2024/4/22/0a688af1-1bb4-4a55-8128-31fc79cc9ad0_6d0abb9a-daff-4fbe-a1c9-2dddb6ae6717"))
    add(categoryList(name = "Vegetables", icon = R.drawable.people, imageURL = "https://instamart-media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_294/NI_CATALOG/IMAGES/CIW/2024/4/22/0a688af1-1bb4-4a55-8128-31fc79cc9ad0_6d0abb9a-daff-4fbe-a1c9-2dddb6ae6717"))
    add(categoryList(name = "Fruits", icon = R.drawable.people, imageURL = "https://instamart-media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_294/NI_CATALOG/IMAGES/CIW/2024/4/22/85df9d8f-175f-4e3a-8945-468bf6317eee_eb9bf247-f2d1-413d-9cf5-48bc870b222f"))
    add(categoryList(name = "Dairy & Bakery", icon = R.drawable.people, imageURL = "https://instamart-media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_294/NI_CATALOG/IMAGES/CIW/2024/4/22/ae5769ba-e22a-4e10-8a4b-0b798c9cdfb9_19051d32-ed28-4996-aeb2-375a5ef80ed3"))
   // add(categoryList(name = "Snacks", icon = R.drawable.people, imageURL = "https://instamart-media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_294/NI_CATALOG/IMAGES/CIW/2024/4/22/0a688af1-1bb4-4a55-8128-31fc79cc9ad0_6d0abb9a-daff-4fbe-a1c9-2dddb6ae6717"))
    add(categoryList(name = "Frozen Foods", icon = R.drawable.people, imageURL = "https://instamart-media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_294/NI_CATALOG/IMAGES/CIW/2024/4/22/67be61b3-99b4-4037-823c-a2cf0155b0af_00bd4c81-9099-4868-be16-0fdeb382a8dc"))
    add(categoryList(name = "Beverages", icon = R.drawable.people, imageURL = "https://www.bigbasket.com/media/customPage/b01eee88-e6bc-410e-993c-dedd012cf04b/91e53046-98e0-4c5b-ae53-7d073e5210e1/e4a9856b-dc3f-4927-a5a1-8edfe8d7dc38/hp_bev_m_health-drinks-&-supplements_480_250923.jpg?tr=w-1920,q=80"))
    add(categoryList(name = "Meat & Fish", icon = R.drawable.people, imageURL = "https://instamart-media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_294/NI_CATALOG/IMAGES/CIW/2024/4/22/e33d8321-cb8c-4732-9149-beb834eb24e4_8cee91b0-a380-43bb-90cf-9346a322ebeb"))
   // add( categoryList(name = "Beauty & Hygiene", icon = R.drawable.people, imageURL ="https://instamart-media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_294/NI_CATALOG/IMAGES/CIW/2024/4/22/0a688af1-1bb4-4a55-8128-31fc79cc9ad0_6d0abb9a-daff-4fbe-a1c9-2dddb6ae6717"))
    add(categoryList(name = "Baby Care", icon = R.drawable.people, imageURL = "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=270/app/assets/products/sliding_images/jpeg/ac531631-c128-48ae-8438-da2791a6ca5c.jpg?ts=1719981628"))
     add(categoryList(name = "Cleaning", icon = R.drawable.people, imageURL = "https://instamart-media-assets.swiggy.com/swiggy/image/upload/fl_lossy,f_auto,q_auto,w_294/NI_CATALOG/IMAGES/CIW/2024/4/2/7c574228-ae92-4199-a45b-dfc3229c09e7_69a4ac73-d9f5-498b-a5cc-40afd90ee4b0"))
    add(categoryList(name = "Pet Care", icon = R.drawable.people, imageURL = "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=270/app/assets/products/sliding_images/jpeg/109f6208-285c-472b-89f5-21432166d2b9.jpg?ts=1718177103"))
}



var categoryListItems = listOf("All", "Vegetables", "Fruits", "Dairy", "Bread & Bakery", "Meat & Fish", "Snacks", "Beverages", "Cleaning", "Pet Care", "Beauty & Hygiene", "Baby Care", "Frozen Foods", "Other")

@Composable
fun CategoryListLazyRow() {
    LazyRow(modifier = Modifier
        .padding(5.dp)
        //.fillMaxSize()
        //.wrapContentWidth()
        //.height(60.dp), // Set an explicit height for the LazyRow
        // .wrapContentHeight(),
        .wrapContentSize(),
        horizontalArrangement = Arrangement.spacedBy(5.dp)

    ) {
        items(categoryListItemsNew.size) { index ->
            //Text("Item $it", fontSize = 24.sp, modifier = Modifier.padding(10.dp))
            CategoryRowCard(index = index)
            //CategoryRowCard1(index = index)
        }
    }
}



/*@Composable
fun CategoryRowCard1(index: Int) {
    val context = LocalContext.current

    var bitmap by remember { mutableStateOf<Bitmap?>(null) }

    // Load image with Glide
    LaunchedEffect(categoryListItemsNew[index].imageURL) {
        Glide.with(context)
            .asBitmap()
            .load(categoryListItemsNew[index].imageURL)
            .into(object : CustomTarget<Bitmap>() {
                override fun onResourceReady(
                    resource: Bitmap,
                    transition: com.bumptech.glide.request.transition.Transition<in Bitmap>?
                ) {
                    bitmap = resource // Store the loaded bitmap
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                    // Handle cleanup if needed
                }
            })
    }

    Card(
        modifier = Modifier
            .wrapContentSize()
            .fillMaxHeight() // Fill the height of the LazyRow
            .clickable { *//* Handle click *//* }
            .padding(2.dp),
       // shape = RoundedCornerShape(10.dp),
       *//* colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Black,
        )*//*
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFFFFF) // Set your desired color here
        ),
    ) {
        Box(
            modifier = Modifier
                .widthIn(min = 105.dp)
                .fillMaxSize()
                .background(Color.Transparent), // Fill the entire card size
            contentAlignment = Alignment.Center // Center content in the box
        ) {
            Column(
                modifier = Modifier
                    .wrapContentSize() // Wrap content size
                    .padding(5.dp), // Padding around the content
                horizontalAlignment = Alignment.CenterHorizontally, // Center horizontally
                verticalArrangement = Arrangement.Center // Center vertically
            ) {
                // Display the round image
                bitmap?.let {
                    Image(
                        bitmap = it.asImageBitmap(),
                        contentDescription = categoryListItemsNew[index].name,
                        modifier = Modifier
                            .size(72.dp)
                            .clip(CircleShape)
                            //.clip(RoundedCornerShape(36.dp)) // Clip to circular shape
                    )
                }

                // Category name (text)
                Text(
                    text = categoryListItemsNew[index].name,
                    fontSize = 12.sp, // Text size
                    color = MaterialTheme.colorScheme.onBackground // Text color
                )
            }
        }
    }
}*/



@Composable
fun CategoryRowCard(index: Int) {
    Card(
        modifier = Modifier
            //.wrapContentSize()
            // .widthIn(min = 75.dp) // Set minimum width
            //.fillMaxHeight() // Fill the height of the LazyRow
            .fillMaxSize()
            .clickable { /* Handle click */ }
            .padding(1.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Black,
        )
    ) {
        Box(
            modifier = Modifier
                //.widthIn(min = 75.dp)
                .fillMaxSize()
                .background(Color.Transparent), // Fill the entire card size
            contentAlignment = Alignment.Center, // Center content in the box

        ) {
            Column(
                modifier = Modifier
                    .wrapContentSize() // Wrap content size
                    .padding(0.dp), // Padding around the content
                horizontalAlignment = Alignment.CenterHorizontally, // Center horizontally
                verticalArrangement = Arrangement.Center // Center vertically
            ) {
                // Icon
                /*                Image(
                                    painter = painterResource(id = R.drawable.people),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .size(22.dp) // Icon size
                                        .padding(bottom = 2.dp) // Space between icon and text
                                )*/
                GlideImage(categoryListItemsNew[index].imageURL, Modifier.size(100.dp))



                // Category name (text)
                 Text(
                     text = categoryListItemsNew[index].name,
                     fontSize = 12.sp, // Text size
                     fontWeight = FontWeight.Bold,
                     color = Color(0xFF000000), //MaterialTheme.colorScheme.onBackground // Text color
                 )
            }
        }
    }
}
