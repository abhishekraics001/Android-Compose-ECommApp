package com.example.composeexample

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mysystemtest.R
import kotlinx.coroutines.delay


@Composable
fun CarouselScreen() {
    val images = listOf(
        // Replace these with your image resources
        /*     painterResource(id = R.drawable.people),
        painterResource(id = R.drawable.people),
        painterResource(id = R.drawable.people)*/
        //"https://www.bigbasket.com/media/assets/asset-media-3586021e-f58f-48b7-b87d-909abc2b3965.jpg",
        "https://www.bigbasket.com/media/uploads/section_item/images/hdpi/hp_cmc_m_gift_card_250923_800px.jpg",
        "https://www.bigbasket.com/media/assets/asset-media-63fcdb79-98cc-4415-99e0-955f30a47a61.jpg",
        "https://www.bigbasket.com/media/assets/asset-media-03d57b35-5e4a-49b1-961e-8fbf0d663e8a.jpg",
        "https://www.bigbasket.com/media/assets/asset-media-76ffa976-17e5-49b4-8148-93a1626f562a.jpg",
        "https://www.bigbasket.com/media/assets/asset-media-39299feb-45ba-4cda-b831-cbb07d6fffa1.jpg",
        "https://www.bigbasket.com/media/assets/asset-media-ec9ca49f-7f02-4c08-9cb4-ca461629c83d.jpg",
        "https://www.bigbasket.com/media/assets/asset-media-c7740f76-b760-400b-900b-768027f809bf.jpg"
    )

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
        pageCount = { images.size })

    LaunchedEffect(Unit) {
        while (true) {
            delay(3000) // Delay for 3 seconds
            pagerState.animateScrollToPage((pagerState.currentPage + 1) % images.size)
        }
    }

    /*  Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            //count = images.size,
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp)
                    .background(Color.White),
                shape = RoundedCornerShape(10.dp)
            ) {
                *//*Image(
                    painter = images[page],
                    contentDescription = "Carousel Image",
                    modifier = Modifier.fillMaxWidth(),
                )*//*
                GlideImage(images[page], Modifier.size(height = 240.dp, width = 450.dp))

            }
        }



        // Indicators
      //  PagerIndicator(pagerState = pagerState, imageCount = images.size)
    }
}
*/

    Box(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            //count = images.size,

            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .height(210.dp)
        ) { page ->
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(2.dp)
                    .background(Color.White),
                elevation = CardDefaults.cardElevation(4.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                GlideImage(images[page], Modifier.size(height = 210.dp, width = 450.dp))
            }
        }

        // Adding a gradient overlay to give merging effect
     /*   Box(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.TopCenter)
                .background(Color.White.copy(alpha = 0.7f))
                .height(60.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter)
                .background(Color.White.copy(alpha = 0.7f))
                .height(60.dp)
        )*/

        // Indicators
        PagerIndicator(pagerState = pagerState, imageCount = images.size)
    }
}

@Composable
fun PagerIndicator(pagerState: PagerState, imageCount: Int) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(imageCount) { index ->
            val color = if (index == pagerState.currentPage) {
                Color.Red
            } else {
                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
            }
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .padding(4.dp)
                    .background(color, shape = RoundedCornerShape(50))
            )
        }
    }
}
