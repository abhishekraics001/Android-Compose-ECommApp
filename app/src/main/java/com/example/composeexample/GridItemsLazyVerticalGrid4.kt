package com.example.composeexample

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Colors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mysystemtest.R


 val shopByCategory = mutableListOf<categoryList>().apply {
    add(categoryList(name = "Vegetables & Fruits", icon = R.drawable.people, imageURL = "https://cdn.grofers.com/app/images/category/cms_images/rc-upload-1702618300089-5"))
    add(categoryList(name = "Dairy & Breakfast", icon = R.drawable.people, imageURL = "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=360/app/images/category/cms_images/icon/14_1678949221877.png"))
    add(categoryList(name = "Munchies", icon = R.drawable.people, imageURL = "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=360/app/images/category/cms_images/icon/1237_1670927167688.png"))
    add(categoryList(name = "Cold Drinks & Juices", icon = R.drawable.people, imageURL = "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=360/app/images/category/cms_images/icon/332_1680269002502.png"))
    add(categoryList(name = "Instant & Frozen", icon = R.drawable.people, imageURL = "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=360/app/images/category/cms_images/icon/15_1676610279582.png"))
    add(categoryList(name = "Tea & Coffee", icon = R.drawable.people, imageURL = "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=360/app/images/category/cms_images/icon/12_1670926444151.png"))
    add(categoryList(name = "Bakery & Biscuits", icon = R.drawable.people, imageURL = "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=360/app/images/category/cms_images/icon/888_1688712847171.png"))
    add(categoryList(name = "Sweet Tooth", icon = R.drawable.people, imageURL = "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=360/app/images/category/cms_images/icon/9_1693202755712.png"))
    add( categoryList(name = "Atta, Rice & Dal", icon = R.drawable.people, imageURL ="https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=360/app/images/category/cms_images/icon/16_1670926686695.png"))
    add(categoryList(name = "Masala & Oil", icon = R.drawable.people, imageURL = "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=360/app/images/category/cms_images/icon/1557_1670927467171.png"))
    add(categoryList(name = "Sauces & Spreads", icon = R.drawable.people, imageURL = "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=360/app/images/category/cms_images/icon/972_1678176421554.png"))
    add(categoryList(name = "Chicken, Meat & Fish", icon = R.drawable.people, imageURL = "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=360/app/images/category/cms_images/icon/4_1670925897047.png"))
     add(categoryList(name = "Paan Corner", icon = R.drawable.people, imageURL = "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=360/app/images/category/cms_images/icon/229_1697713631135.png"))
     add(categoryList(name = "Organic & Premium", icon = R.drawable.people, imageURL = "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=360/app/images/category/cms_images/icon/175_1670926891460.png"))
     add(categoryList(name = "Baby Care", icon = R.drawable.people, imageURL = "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=360/app/images/category/cms_images/icon/7_1688712826553.png"))
     add(categoryList(name = "Pharma & Wellness", icon = R.drawable.people, imageURL = "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=360/app/images/category/cms_images/icon/287_1684822344371.png"))
     add(categoryList(name = "Cleaning Essentials", icon = R.drawable.people, imageURL = "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=360/app/images/category/cms_images/icon/18_1692167327246.png"))
     add(categoryList(name = "Home & Office", icon = R.drawable.people, imageURL = "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=360/app/images/category/cms_images/icon/1379_1670927201924.png"))
     add(categoryList(name = "Personal Care", icon = R.drawable.people, imageURL = "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=360/app/images/category/cms_images/icon/163_1698986628342.png"))
     add(categoryList(name = "Pet Care", icon = R.drawable.people, imageURL = "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=360/app/images/category/cms_images/icon/5_1686741293107.png"))
}

@Composable
fun GridItemsLazyVerticalGrid4() {
    // LazyVerticalGrid with 2 columns
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        contentPadding = PaddingValues(2.dp),
        verticalArrangement = Arrangement.spacedBy(1.dp),
        horizontalArrangement = Arrangement.spacedBy(1.dp),
        modifier = Modifier.fillMaxSize().height(80.dp)
    ) {
        items(shopByCategory.size) { index ->
            ProductItem4(index = index)
        }
    }
}


@Composable
fun ProductItem4(index: Int) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFFFFF) // Set your desired color here
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable {  }
            //.wrapContentHeight()
            .height(125.dp)
            .padding(2.dp),


        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Column(
            modifier = Modifier.padding(1.dp),
            horizontalAlignment = Alignment.CenterHorizontally // Center the image
        ) {
            // Product Image centered
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                contentAlignment = Alignment.Center // Center the image in the Box
            ) {
                /* Image(
                     painter = painterResource(id = R.drawable.people),
                     contentDescription = "PName $index",
                     contentScale = ContentScale.Crop,
                     modifier = Modifier
                         .size(70.dp)
                         .padding(bottom = 8.dp)
                 )*/
                GlideImage(shopByCategory[index].imageURL, Modifier.size(85.dp))
            }

            // Product Name
     /*       Text(
                text = shopByCategory[index].name,
                fontSize = 12.sp,
                fontWeight = FontWeight.Thin,
                color = Color.Black,
                lineHeight = 12.sp, // Adjust line height
                modifier = Modifier.padding(0.dp),
                textAlign = TextAlign.Center, // Center the text
                modifier = Modifier.padding(top = 4.dp) // Add top padding if needed
            )*/
            Text(
                text = shopByCategory[index].name,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                lineHeight = 12.sp, // Adjust line height
                textAlign = TextAlign.Center, // Center the text
                modifier = Modifier.padding(top = 2.dp) // Add top padding if needed
            )

            /* // Product Price
             Text(
                 text = "INR 100/-",
                 fontSize = 14.sp,
                 color = Color.Gray,
                 modifier = Modifier
                     .padding(bottom = 2.dp)
                     .align(Alignment.Start) // Left-align text
             )

             // Product Category
             Text(
                 text = "Cat $index",
                 fontSize = 14.sp,
                 color = MaterialTheme.colorScheme.primary,
                 modifier = Modifier.align(Alignment.Start) // Left-align text
             )*/
        }
    }
}