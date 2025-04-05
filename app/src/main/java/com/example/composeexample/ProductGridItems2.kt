package com.example.composeexample

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Colors
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material.icons.rounded.CurrencyRupee
import androidx.compose.material.icons.rounded.Money
import androidx.compose.material.icons.rounded.ShoppingBag
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mysystemtest.R

//val px =
var productItemsList = mutableListOf<Product>().apply {
    add( Product(
        image = "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=720/app/assets/products/sliding_images/jpeg/28b248cd-5f36-413d-b5d5-5f867cfdb762.jpg",
        name = "Lady Finger (Bhindi)",
        quantity = "260 - 275",
        unit = "Gram",
        price = 56.99,
        discount = 6.00,
        rating = 4.5,
        reviews = 100)
    )
    add(Product(
        image = "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=900/app/assets/products/sliding_images/jpeg/b5fc630a-c183-47e8-979e-20c04f601039.jpg",
        name = "Hybrid Tomato (Tamatar)",
        quantity = "500 - 7500",
        unit = "Gram",
        price = 29.99,
        discount = 11.00,
        rating = 4.5,
        reviews = 100
    ))
    add(Product(
        image = "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=900/app/assets/products/sliding_images/jpeg/a1ba074a-c085-4dd1-b4a4-2f247d6f211d.jpg",
        name = "Onion (Pyaz)",
        quantity = "0.90 - 1.10",
        unit = "Kg",
        price = 80.99,
        discount = 4.00,
        rating = 4.5,
        reviews = 100
    ))
    add(Product(
        image = "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=900/app/assets/products/sliding_images/jpeg/92cdc38d-4c41-4069-926c-79a9acc996be.jpg",
        name = "Potato (Aloo)",
        quantity = "0.95 - 1.05",
        unit = "Kg",
        price = 42.99,
        discount = 10.00,
        rating = 4.5,
        reviews = 100
    ))
    add(Product(
        image = "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=900/app/assets/products/sliding_images/jpeg/c655faa5-2b29-4714-8411-c98b67f4ef51.jpg",
        name = "Lemon (Nimbo)",
        quantity = "150 - 210",
        unit = "Gram",
        price = 68.99,
        discount = 9.00,
        rating = 4.5,
        reviews = 100
    ))
    add(Product(
        image = "https://cdn.grofers.com/cdn-cgi/image/f=auto,fit=scale-down,q=70,metadata=none,w=900/app/assets/products/sliding_images/jpeg/0c0170fb-baf2-4947-b512-a6f0a5e6ad01.jpg",
        name = "Green Capsicum (Shimla Mirch)",
        quantity = "250 - 300",
        unit = "Gram",
        price = 72.0,
        discount = 7.00,
        rating = 4.5,
        reviews = 100
    ))
}



@Composable
fun ProductGridItems2() {
    //productItemsList.add(px)

    // LazyVerticalGrid with 2 columns
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(5.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        items(productItemsList.size) { index ->
            //ProductItem(index = index)
            ProductItem2(index = index)
        }
    }
}

/*

@Composable
fun ProductItem(index: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally // Center the image
        ) {
            // Product Image centered
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                contentAlignment = Alignment.Center // Center the image in the Box
            ) {
                GlideImage(categoryListItemsNew[index].imageURL, Modifier.size(72.dp))
            }

            // Product Name
            Text(
                text = "Product $index",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(bottom = 2.dp)
                    .align(Alignment.Start) // Left-align text
            )

            // Product Price
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
            )
        }
    }
}*/



@Composable
fun AddToCartButton1(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(2.dp)
            .wrapContentSize(),
            //.size(width = 50.dp, height = 40.dp), // Size of the button
        shape = RoundedCornerShape(5.dp), // Rounded corners
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Red, // Button background color
            contentColor = Color.White // Text color
        )
    ) {
        Text(
            text = "+",
            fontSize = 18.sp, // Font size of the button text
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Composable
fun ProductItem(index: Int) {
    val product = Product(
        image = "https://www.bigbasket.com/media/uploads/p/s/10000017_21-fresho-baby-corn-peeled.jpg", // Replace with your image URL
        name = "Onion (Pyaz)",
        price = 29.99,
        discount = 5.00
    )


        Card(
            modifier = Modifier
                .padding(2.dp)
                .fillMaxWidth()
                .height(220.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
                contentColor = Color.Black,
            ),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(2.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(0.dp)
                    .background(Color.White),
                horizontalAlignment = Alignment.Start
            ) {
                // Product Image
                GlideImage(
                    product.image,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(0.dp)
                )

                Spacer(modifier = Modifier.height(2.dp))

                // Product Name
                Text(
                    text = product.name,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .padding(bottom = 1.dp, start = 5.dp)
                        .height(22.dp)
                )


      /*          Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        //.height(60.dp)
                        .wrapContentHeight()
                        .padding(1.dp),
                    //verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {*/
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.padding(start = 5.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.ShoppingBag,
                            contentDescription = null, // Provide a description for accessibility,
                            modifier = Modifier.size(16.dp)
                            )
                        Text(
                            text = "0.75 - 1.25",
                            style = MaterialTheme.typography.bodySmall,
                            textAlign = TextAlign.Start
                        )
                        Spacer(modifier = Modifier.width(4.dp)) // Add space between price and discount
                        Text(
                            text = "KG",
                            color = Color.Red,
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.bodySmall,
                        )
                    }
              //  }

                // Price and Discount
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        //.height(60.dp)
                        .wrapContentHeight()
                        .padding(0.dp),
                    //verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                  //  Column(modifier = Modifier.fillMaxWidth()) {


                    Row(
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier.padding(start = 5.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.CurrencyRupee,
                            contentDescription = null, // Provide a description for accessibility
                            modifier = Modifier.size(16.dp)
                        )

                        Text(

                            text = "₹${product.price}",
                            style = MaterialTheme.typography.bodySmall,
                            textAlign = TextAlign.Start
                        )
                        Spacer(modifier = Modifier.width(4.dp)) // Add space between price and discount
                        Text(
                            text = "${product.discount}",
                            color = Color.Red,
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.bodySmall,
                        )
                    }



                   // AddToCartButton(onClick = { /* Handle add to cart logic */ })




                    Spacer(modifier = Modifier.height(1.dp))
            //    }
            }
            }

        }


   /* Card(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth()
            .height(220.dp)
            .background(Color.White),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Black,
        ),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GlideImage(product.image,
                modifier = Modifier
                    //.size(142.dp)
                    .fillMaxWidth()
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(0.dp)
                   // .background(Color.White, shape = RoundedCornerShape(8.dp))
            )


            Spacer(modifier = Modifier.height(2.dp))

            // Product Name
            Text(
                text = product.name,

               // style = MaterialTheme.typography.titleMedium,
                fontSize = 14.sp,
                //fontSize = 12.dp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 1.dp)
                    .height(22.dp)
            )

            // Price and Discount
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .padding(
                    start = 10.dp, end = 10.dp, top = 0.dp,
                    bottom = 0.dp
                ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween) {
                Row(
                   horizontalArrangement = Arrangement.Start
                ) {

                    Text(
                        text = "₹${product.price}",
                        style = MaterialTheme.typography.bodySmall
                    )

                    Spacer(modifier = Modifier.height(1.dp))

                    Text(
                        text = "-₹${product.discount}",
                        color = Color.Red,
                        style = MaterialTheme.typography.bodySmall,

                        )
                }

                // Add to Cart Button
                OutlinedButton(
                    onClick = {  },
                    modifier = Modifier
                        .size(height = 20.dp, width = 40.dp)
                        .background(Color.Red, shape = RoundedCornerShape(0.dp)),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.Black
                    )
                ) {
                    Text(
                        text = "+",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        style = MaterialTheme.typography.bodySmall,
                    )
                }
                }


         Spacer(modifier = Modifier.height(1.dp))


        }
    }*/
}



@Composable
fun ProductItem2(index: Int) {


    Card(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth()
            .height(220.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Black,
        ),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp)
                .background(Color.White),
            horizontalAlignment = Alignment.Start
        ) {
            // Use a Box to overlay the button on top of the image
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // Make the Box take up available height
            ) {
                GlideImage(productItemsList[index].image,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight() // Ensure the image fills the Box
                )

                Box(modifier = Modifier.align(Alignment.BottomEnd) ){
                    Column(
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.End,
                        modifier = Modifier.padding(5.dp)
                    ) {

                        LikeButton(onClick = { /* Handle like button click */ })
                        ShareButton(onClick = { /* Handle share button click */ })

                        // AddToCartButton positioned on top of the image
                        AddToCartButton(
                            onClick = { /* Handle add to cart logic */ },
                            modifier = Modifier
                                //.align(Alignment.BottomEnd) // Position the button at the top right
                                .padding(2.dp) // Add some padding around the button
                        )

                    }

                }


            }

            Spacer(modifier = Modifier.height(2.dp))

            // Product Name
            Text(
                text = productItemsList[index].name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .padding(bottom = 1.dp, start = 5.dp)
                    .height(22.dp)
            )

            // Details Row
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(start = 5.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.ShoppingBag,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = "${productItemsList[index].quantity}",
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "${productItemsList[index].unit}",
                    color = Color.Red,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.bodySmall,
                )
            }

            // Price and Discount
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.padding(start = 5.dp)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.CurrencyRupee,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = "₹${productItemsList[index].price}",
                        style = MaterialTheme.typography.bodySmall,
                        textAlign = TextAlign.Start
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "${productItemsList[index].discount}",
                        color = Color.Red,
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.bodySmall,
                    )
                }
            }

            Spacer(modifier = Modifier.height(1.dp))
        }
    }
}




@Composable
fun AddToCartButton(modifier: Modifier, onClick: () -> Unit) {
    /* Button(
         onClick = onClick,
         modifier = modifier
             .height(40.dp) // Set height to 40.dp
             .width(50.dp) // Set width to a smaller value
             .padding(0.dp)
             .border(
                 width = 1.dp,
                 color = Color.Red,
                 shape = RoundedCornerShape(0.dp)
             )

             //.border(1.dp, Color.Green) // Border color and shape
             .clickable(onClick = onClick) ,// Make the Box clickable
             //.background(Color.White, RoundedCornerShape(1.dp)), //, // No padding
         shape = RoundedCornerShape(5.dp), // Rounded corners

         colors = ButtonDefaults.buttonColors(
             containerColor = Color.Gray, // Background color
            // contentColor = Color.White, // Text color,


         )
     ) {
         Text(
             text = "+",
             fontSize = 16.sp, // Smaller font size for better fit
             fontWeight = FontWeight.Bold,
             modifier = Modifier
                 .height(24.dp)
                 .align(Alignment.CenterVertically)
         )
     }*/



    /*    Surface(
            modifier = Modifier
                .size(50.dp) // Set the size of the button
                .padding(4.dp), // Optional padding around the button
            shape = RoundedCornerShape(5.dp), // Rounded corners
            elevation = 4.dp, // Set elevation
            color = Color.Transparent // Background color (transparent for text button)
        ) {*/
    TextButton(
        onClick = onClick,
        modifier = modifier
            .size(45.dp) // Set the size to 40x40 dp
            .padding(5.dp)
            .border(
                width = 1.dp,
                color = Color.Blue,
                shape = RoundedCornerShape(5.dp)
            ), // Outline border
        colors = ButtonDefaults.textButtonColors(
            containerColor = Color.Transparent,
            // backgroundColor = Color.Transparent, // Transparent background
            contentColor = Color.Blue // Text color
        )
    ) {
        Text(
            text = "+", // Text to display
            fontSize = 18.sp, // Adjust font size as needed
            fontWeight = FontWeight.Bold
        )
    }
    //  }
}


@Composable
fun LikeButton(modifier: Modifier = Modifier, onClick: () -> Unit) {

    // Wrap in a Surface or Card to provide elevation
    Surface(
        modifier = Modifier
            .size(40.dp) // Set the size of the button
            .padding(4.dp), // Optional padding around the button
        shape = RoundedCornerShape(5.dp), // Rounded corners
        elevation = 5.dp, // Set elevation
        color = Color.Red.copy(alpha = 0.2f) // Optional background color
    ) {
        IconButton(
            onClick = onClick,
            modifier = modifier
                .size(36.dp) // Set size of the icon button
            //.background(Color.Red, shape = RoundedCornerShape(5.dp)) // Background color with rounded corners
        ) {
            Icon(
                imageVector = Icons.Outlined.Favorite, // Use your desired icon
                contentDescription = "Like Product",
                tint = Color.Black // Icon color
            )
        }
    }
}

@Composable
fun ShareButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    // Wrap in a Surface or Card to provide elevation
    Surface(
        modifier = Modifier
            .size(40.dp) // Set the size of the button
            .padding(4.dp), // Optional padding around the button
        shape = RoundedCornerShape(5.dp), // Rounded corners
        elevation = 5.dp, // Set elevation
        color = Color.Red.copy(alpha = 0.2f) // Optional background color
    ) {
        IconButton(
            onClick = onClick,
            modifier = modifier
                .size(36.dp) // Set size of the icon button
            //.background(Color.Red, shape = RoundedCornerShape(5.dp)) // Background color with rounded corners
        ) {
            Icon(
                imageVector = Icons.Outlined.Share, // Use your desired icon
                contentDescription = "Share Product",
                tint = Color.Black // Icon color
            )
        }
    }
}


data class Product(
    val image: String, // Image URL
    val name: String,
    val price: Double,
    val discount: Double,
    var quantity: String = "0.75 - 1.25",
    val unit: String = "KG",
    val rating: Double = 0.0,
    val reviews: Int = 0

)