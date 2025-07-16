package com.example.ytmusic.presentation.ui.home

import QuickPickList
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ytmusic.presentation.album.quickAlbums
import com.example.ytmusic.presentation.ui.component.CategoryView

@Composable
fun HomePage(navController: NavController) {
    val listState = rememberLazyListState()


        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp),
            contentPadding = PaddingValues(bottom = 80.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            stickyHeader {
                CategoryView()
            }

            item {
                SpeedDial()
            }

            item {
                QuickPickList(quickAlbums = quickAlbums)
            }

            item {
                MusicVideoList()
            }
            item {
                AlbumsForList()
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(onClick = {
                        navController.navigate("player")
                    },
                        modifier = Modifier.border(1.dp, Color.White),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White,
                            backgroundColor = Color.Transparent
                        )) {
                        Text(text = "Start Music")
                    }
                }
            }
        }
    }
