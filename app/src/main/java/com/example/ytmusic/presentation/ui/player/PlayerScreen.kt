package com.example.ytmusic.presentation.ui.player

import SongPreview
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.media3.common.MediaItem
import androidx.navigation.NavController
import com.example.ytmusic.data.local.songList


@Composable
fun PlayerScreen(navController: NavController) {
    val context = LocalContext.current
    val viewModel: ExoPlayerViewModel = viewModel()
    val exoPlayer = viewModel.exoPlayer

    // ✅ Collecting flows properly
    val isPlaying by viewModel.isPlaying.collectAsState()
    val position by viewModel.position.collectAsState()
    val duration by viewModel.duration.collectAsState()

    var selectedTab by remember { mutableStateOf("Song") }
    var selectedSong by remember { mutableStateOf(songList[0]) } // default song


    // 🔁 Update media source when switching tabs
    LaunchedEffect(selectedTab) {
        val mediaUri = Uri.parse(
            "android.resource://${context.packageName}/${
                if (selectedTab == "Song") selectedSong.audioResId else selectedSong.videoResId
            }"
        )


        val currentPos = exoPlayer.currentPosition
        exoPlayer.setMediaItem(MediaItem.fromUri(mediaUri))
        exoPlayer.prepare()
        exoPlayer.seekTo(currentPos)

        if (isPlaying) exoPlayer.play() else exoPlayer.pause()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(WindowInsets.systemBars.asPaddingValues())
    ) {
        PlayerTop(
            selectedTab = selectedTab,
            onTabSelected = { selectedTab = it },
            navController =navController
        )

        if (selectedTab == "Song") {
            SongPreview(
                viewModel = viewModel,
                onPlayPauseToggle = {
                    if (isPlaying) viewModel.pause() else viewModel.play()
                },
                onSeek = { pos -> viewModel.seekTo(pos) }
            )
        } else {
            VideoScreen(
                viewModel = viewModel,
                onPlayPauseToggle = {
                    if (isPlaying) viewModel.pause() else viewModel.play()
                },
                onSeek = { pos -> viewModel.seekTo(pos) }
            )
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }
}


@Composable
fun PlayerTop(
    selectedTab: String,
    onTabSelected: (String) -> Unit,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 10.dp),
    ) {
        // ⬅️ Left Arrow
        Icon(
            imageVector = Icons.Default.KeyboardArrowDown,
            contentDescription = "Arrow Down",
            tint = Color.Gray,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .clickable {
                    navController.popBackStack() // ⬅️ this goes back to the previous screen
                }
        )


        // 🎵 Tab Selector (Center)
        Row(
            modifier = Modifier
                .align(Alignment.Center)
                .clip(RoundedCornerShape(25.dp))
                .background(Color.DarkGray)
        ) {
            // Song Tab
            Box(
                modifier = Modifier
                    .height(30.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .background(
                        if (selectedTab == "Song") Color.Gray else Color.DarkGray.copy(alpha = 0.7f)
                    )
                    .clickable { onTabSelected("Song") }
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Song",
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            // Video Tab
            Box(
                modifier = Modifier
                    .height(30.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .background(
                        if (selectedTab == "Video") Color.Gray else Color.DarkGray.copy(alpha = 0.7f)
                    )
                    .clickable { onTabSelected("Video") }
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Video",
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }

        // ➡️ Right Icons
        Row(
            modifier = Modifier.align(Alignment.CenterEnd),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(1.dp)
        ) {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Cast,
                    contentDescription = "Cast",
                    tint = Color.LightGray
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "More Options",
                    tint = Color.LightGray
                )
            }
        }
    }
}
