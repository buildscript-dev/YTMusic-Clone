package com.example.ytmusic.presentation.ui.explore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.ytmusic.presentation.ui.home.albums

@Composable
fun ExploreAblum(){
    Column(){
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Text("New albums and single", color =  Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.ArrowForwardIos, contentDescription = "Arrow", tint = Color.White)
            } }

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = 8.dp)
        ) {

            items(albums){ album ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(2.dp) // just a bit of space around each item
                ) {
                    Card(
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .fillMaxWidth() // take full grid cell width
                            .height(150.dp)
                    ) {
                        AsyncImage(
                            model = album.imageUrl,
                            contentDescription = album.name,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = album.name,
                        fontSize = 12.sp,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

        }


        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Text("Moods and genres", color =  Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Default.ArrowForwardIos, contentDescription = "Arrow", tint = Color.White)
            } }
//        LazyVerticalGrid(
//            columns = GridCells.Fixed(3),
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(horizontal = 4.dp),
//            verticalArrangement = Arrangement.spacedBy(4.dp),
//            horizontalArrangement = Arrangement.spacedBy(4.dp)
//        ) {
//            items(pages[page]) { album ->
//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    modifier = Modifier.padding(2.dp) // just a bit of space around each item
//                ) {
//                    Card(
//                        shape = RoundedCornerShape(8.dp),
//                        modifier = Modifier
//                            .fillMaxWidth() // take full grid cell width
//                            .aspectRatio(1f) // stay square
//                    ) {
//                        Box(modifier = Modifier.fillMaxSize()
//                            .aspectRatio(0.1f)
//                            .background(ColorBox)
//                            .clip(RoundedCornerShape(8.dp)))
//                    }
//
//
//                 Text(
//                        text = album.name,
//                        fontSize = 12.sp,
//                        color = Color.White,
//                        maxLines = 1,
//                        overflow = TextOverflow.Ellipsis,
//                        textAlign = TextAlign.Center,
//                        modifier = Modifier.fillMaxWidth()
//                    )
//                }
//            }
//        }





    }
}


//data class mood(val name: String, val Color)