package com.example.ytmusic.presentation.ui.sample

import android.content.Context
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
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
import androidx.navigation.NavController
import androidx.navigation.NavHostController

import com.example.ytmusic.R

@Composable

fun SampleScreen(navController: NavController){
    ShortsScreen()
}
//fun SampleScreen(navController: NavHostController) {
//    val context = LocalContext.current
//    val buttonBackground = Color(0x33FFFFFF)
//
//    // Icons with labels
//    data class IconWithLabel(val icon: ImageVector, val label: String)
//
//    val iconButtons = listOf(
//        IconWithLabel(Icons.Filled.ThumbUp, "2.4 lakh"),
//        IconWithLabel(Icons.Filled.Comment, "3.9K"),
//        IconWithLabel(Icons.Filled.PlaylistAdd, "Save"),
//        IconWithLabel(Icons.Filled.Savings, "Shorts"),
//        IconWithLabel(Icons.Filled.Share, "2.2 lakh"),
//        IconWithLabel(Icons.Filled.PlayArrow, "Play"),
//    )
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Black)
//    ) {
//        // 🎥 Center Video
//        VideoPlayer(
//            context = context,
//            videoUri = "https://www.example.com/video.mp4", // Replace this with your actual URL
//            modifier = Modifier.fillMaxSize()
//        )
//
//        // 👉 Right-side buttons
//        Column(
//            modifier = Modifier
//                .align(Alignment.CenterEnd)
//                .padding(end = 16.dp),
//            verticalArrangement = Arrangement.spacedBy(12.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            iconButtons.forEach { item ->
//                Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                    Box(
//                        modifier = Modifier
//                            .size(56.dp)
//                            .background(buttonBackground, shape = CircleShape),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        Icon(
//                            imageVector = item.icon,
//                            contentDescription = item.label,
//                            tint = Color.White,
//                            modifier = Modifier.size(28.dp)
//                        )
//                    }
//                    Spacer(modifier = Modifier.height(4.dp))
//                    Text(
//                        text = item.label,
//                        color = Color.White,
//                        fontSize = 12.sp
//                    )
//                }
//            }
//        }
//
//        // ⬇ Bottom-left Card
//        Card(
//            backgroundColor = Color.DarkGray,
//            elevation = 8.dp,
//            modifier = Modifier
//                .fillMaxWidth()
//                .align(Alignment.BottomStart)
//                .padding(12.dp)
//        ) {
//            Row(
//                modifier = Modifier
//                    .padding(12.dp)
//                    .fillMaxWidth(),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Image(
//                        painter = painterResource(id = R.drawable.logo),
//                        contentDescription = "Image",
//                        contentScale = ContentScale.Crop,
//                        modifier = Modifier
//                            .size(48.dp)
//                            .clip(CircleShape)
//                    )
//
//                    Spacer(modifier = Modifier.width(12.dp))
//
//                    Column {
//                        Text(
//                            text = "Hood Famous",
//                            color = Color.White,
//                            fontSize = 16.sp
//                        )
//                        Text(
//                            text = "Navaan Sandhu",
//                            color = Color.LightGray,
//                            fontSize = 14.sp
//                        )
//                    }
//                }
//
//                IconButton(onClick = { /* TODO */ }) {
//                    Icon(
//                        imageVector = Icons.Filled.MoreHoriz,
//                        contentDescription = "More Options",
//                        tint = Color.White
//                    )
//                }
//            }
//        }
//    }
//}
