package com.example.ytmusic.presentation.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.waterfall
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ytmusic.R
import com.example.ytmusic.presentation.ui.component.CategoryView

@Composable
fun HomePage(){

    Column(modifier = Modifier.fillMaxSize()
        .background(color = Color.Black)
        .padding(WindowInsets.waterfall.asPaddingValues())
    ) {


        Row(modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Image(painter = painterResource(id = R.drawable.logo),
                contentDescription = "Youtube Music Logo",
                modifier = Modifier.size(100.dp))

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            IconButton(onClick = { /* Do something */ }) {
                Icon(imageVector = Icons.Default.Notifications, contentDescription = "Home", tint = Color.White)
            }
            IconButton(onClick = { /* Do something else */ }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Home", tint = Color.White)
            }
            IconButton(onClick = { /* Do another thing */ }) {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Home", tint = Color.White)
            }
        }

        }


        CategoryView()


        SpeedDial()



    }



}