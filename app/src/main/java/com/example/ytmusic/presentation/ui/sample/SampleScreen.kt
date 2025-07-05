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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ytmusic.R

@Composable
fun SampleScreen(navController: NavHostController) {
    val buttonBackground = Color(0x33FFFFFF)
    val iconButtons = listOf(
        Icons.Filled.ThumbUp,
        Icons.Filled.Email,
        Icons.Filled.Menu,
        Icons.Filled.ShoppingCart,
        Icons.Filled.Share,
        Icons.Filled.PlayArrow,
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        // Column at the bottom end
        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.End
        ) {
            iconButtons.forEach { icon ->
                IconButton(
                    onClick = { /* TODO: handle click */ },
                    modifier = Modifier
                        .size(56.dp)
                        .background(buttonBackground, shape = CircleShape)
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = "Icon",
                        tint = Color.White,
                        modifier = Modifier.size(28.dp)
                    )
                }
            }

            // 👇 Card comes right after buttons
            Card(
                backgroundColor = Color.DarkGray,
                elevation = 8.dp,
                modifier = Modifier
                    .fillMaxWidth()
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
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
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
                            imageVector = Icons.Filled.MoreVert,
                            contentDescription = "More Options",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
}
