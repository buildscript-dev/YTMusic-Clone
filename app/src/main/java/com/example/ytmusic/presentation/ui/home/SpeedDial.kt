package com.example.ytmusic.presentation.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
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
import com.example.ytmusic.R

@Composable
fun SpeedDial() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
       Row {
           // Left side: Image + Column
           Image(
               painter = painterResource(id = R.drawable.profile),
               contentDescription = "Profile Image",
               contentScale = ContentScale.Crop, // ← This fills the circle nicely
               modifier = Modifier
                   .size(50.dp) // Set size ONCE
                   .clip(CircleShape) // Clip AFTER size is locked in
                   .padding()
           )


           Column {
               Text(text = "NOTHING STRIX", color = Color.Gray, fontSize = 14.sp)
               Text(
                   text = "Speed Dial",
                   fontSize = 24.sp,
                   fontWeight = FontWeight.Bold,
                   color = Color.White
               )
           }


       }
        // Right side: Arrow icon
        IconButton(onClick = { /* TODO: Navigate or perform action */ }) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Arrow",
                tint = Color.White
            )
        }
    }
}

