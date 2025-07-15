package com.example.ytmusic.presentation.ui.home

import android.graphics.Paint
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.HorizontalRule
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

data class MusicVideoData(val title: String, val artists: String , val view: String, val imageUrl: String)


val musicVideo = listOf(
    MusicVideoData(title = "One of One" , artists ="Jerry" , view = "53 lakh views" , imageUrl ="https://i.ytimg.com/vi/uKHlnmepnNA/maxresdefault.jpg") ,
    MusicVideoData(title = "One of One" , artists ="Jerry" , view = "53 lakh views" , imageUrl ="https://i.ytimg.com/vi/uKHlnmepnNA/maxresdefault.jpg") ,
    MusicVideoData(title = "One of One" , artists ="Jerry" , view = "53 lakh views" , imageUrl ="https://i.ytimg.com/vi/uKHlnmepnNA/maxresdefault.jpg") ,
    MusicVideoData(title = "One of One" , artists ="Jerry" , view = "53 lakh views" , imageUrl ="https://i.ytimg.com/vi/uKHlnmepnNA/maxresdefault.jpg") ,

    )

@Composable
fun MusicVideoList() {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Music Video for you",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Box(
            modifier = Modifier
                .clip(CircleShape)
                .border(
                    width = 1.dp,
                    color = Color.DarkGray,
                    shape = CircleShape
                )
                .padding(horizontal = 12.dp, vertical = 4.dp)
                .clickable {}
        ) {
            Text("Play all", color = Color.White, fontSize = 14.sp)
        }
    }

    Spacer(modifier = Modifier.height(8.dp))

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp, start = 14.dp)
    ) {
        items(musicVideo) { video ->
            Column(
                modifier = Modifier
                    .padding(end = 12.dp)
                    .width(290.dp)
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(8.dp))
                ) {
                    AsyncImage(
                        model = video.imageUrl,
                        contentDescription = video.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )

                    Icon(
                        imageVector = Icons.Default.MoreHoriz,
                        contentDescription = "More Options",
                        tint = Color.White,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(4.dp)
                    )
                }

                Text(
                    text = video.title,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(top = 4.dp)
                )

                Text(
                    text = "${video.artists} • ${video.view}",
                    fontSize = 14.sp,
                    color = Color.LightGray,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}