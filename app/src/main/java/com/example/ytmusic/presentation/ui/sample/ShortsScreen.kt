package com.example.ytmusic.presentation.ui.sample

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ytmusic.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ShortsScreen() {
    val context = LocalContext.current
    val videoList = listOf(
        "android.resource://${context.packageName}/${R.raw.sample4}",
        "android.resource://${context.packageName}/${R.raw.sample5}",
        "android.resource://${context.packageName}/${R.raw.sample8}",
        "android.resource://${context.packageName}/${R.raw.sample7}",
        "android.resource://${context.packageName}/${R.raw.sample6}",
        "android.resource://${context.packageName}/${R.raw.sample2}",
        "android.resource://${context.packageName}/${R.raw.sample1}",
        "android.resource://${context.packageName}/${R.raw.sample3}",
        "android.resource://${context.packageName}/${R.raw.sample9}",
    )

    val videoLike = listOf(
        "2.5m",
        "3.5k",
        "5.5b",
        "6.5k",
        "980",
        "12m",
        "9.3k"
    ).shuffled()
    val videoComment = listOf(
        "47.4k",
        "1.2k",
        "3.9b",
        "2.0k",
        "123",
        "6.7m",
        "4.1k"
    ).shuffled()


    val pagerState = rememberPagerState()

    VerticalPager(
        count = videoList.size,
        state = pagerState,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) { page ->

        Box(modifier = Modifier.fillMaxSize()) {
            // 🎥 Fullscreen Video
            VideoPlayer(
                context = context,
                videoUri = videoList[page],
                modifier = Modifier.fillMaxSize()
            )

            // 👉 Right-side action buttons
            val buttonBackground = Color(0x33FFFFFF)
            val iconButtons = listOf(
                IconWithLabel(Icons.Filled.ThumbUp, videoLike[page]),
                IconWithLabel(Icons.Filled.Comment, videoComment[page]),
                IconWithLabel(Icons.Filled.PlaylistAdd, "Save"),
                IconWithLabel(Icons.Filled.Savings, "Shorts"),
                IconWithLabel(Icons.Filled.Share, "Share"),
                IconWithLabel(Icons.Filled.PlayArrow, "Play")
            )

            Column(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                iconButtons.forEach { item ->
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(
                            modifier = Modifier
                                .size(56.dp)
                                .background(buttonBackground, shape = CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.label,
                                tint = Color.White,
                                modifier = Modifier.size(28.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = item.label,
                            color = Color.White,
                            fontSize = 12.sp
                        )
                    }
                }
            }

            // ⬇ Bottom card
            Card(
                backgroundColor = Color.Transparent,
                elevation = 8.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomEnd)
                    .padding(12.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = "Image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(48.dp)
                                .clip(CircleShape)
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Column {
                            Text(
                                text = "Hood Famous",
                                color = Color.White,
                                fontSize = 16.sp
                            )
                            Text(
                                text = "Navaan Sandhu",
                                color = Color.LightGray,
                                fontSize = 14.sp
                            )
                        }
                    }

                    IconButton(onClick = { /* TODO */ }) {
                        Icon(
                            imageVector = Icons.Filled.MoreHoriz,
                            contentDescription = "More Options",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
}

// Data class to hold icon + label combo
data class IconWithLabel(val icon: ImageVector, val label: String)
