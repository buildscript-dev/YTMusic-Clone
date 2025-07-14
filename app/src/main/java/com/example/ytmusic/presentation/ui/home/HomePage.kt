package com.example.ytmusic.presentation.ui.home

import QuickPickList
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ytmusic.presentation.album.quickAlbums
import com.example.ytmusic.presentation.ui.component.CategoryView

@Composable
fun HomePage(navController: NavController) {
    val listState = rememberLazyListState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        // Static top section
        CategoryView()

        // Scrollable content
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp),
            contentPadding = PaddingValues(bottom = 80.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
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

        }
    }
}
