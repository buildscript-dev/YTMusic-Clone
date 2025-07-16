package com.example.ytmusic.presentation.ui.player

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Repeat
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material.icons.outlined.Shuffle
import androidx.compose.material.icons.outlined.ThumbDown
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material.icons.rounded.PauseCircle
import androidx.compose.material.icons.rounded.PlayCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun VideoScreen(
    viewModel: ExoPlayerViewModel,
    onPlayPauseToggle: () -> Unit,
    onSeek: (Long) -> Unit
) {
    val exoPlayer = viewModel.exoPlayer
    val isPlaying by viewModel.isPlaying.collectAsState()
    val position by viewModel.position.collectAsState()
    val duration by viewModel.duration.collectAsState()

    Column {
        // Preview Component (make sure it's implemented)
        VideoPreview(exoPlayer = exoPlayer)

        // Song info
        Text(
            "Shape of You",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 26.sp,
            modifier = Modifier.padding(start = 30.dp)
        )
        Text(
            "Ed Sheeran",
            color = Color.LightGray,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 30.dp, top = 4.dp)
        )

        // Like / Dislike Row
        Box(
            modifier = Modifier
                .padding(start = 24.dp, top = 10.dp)
                .clip(RoundedCornerShape(25.dp))
                .background(Color.DarkGray)
                .wrapContentSize()
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                IconButton(onClick = {}) {
                    Icon(Icons.Outlined.ThumbUp, contentDescription = "Like", tint = Color.LightGray)
                }
                Box(
                    modifier = Modifier
                        .width(1.dp)
                        .height(24.dp)
                        .background(Color.LightGray)
                )
                IconButton(onClick = {}) {
                    Icon(Icons.Outlined.ThumbDown, contentDescription = "Dislike", tint = Color.LightGray)
                }
            }
        }

        // Slider
        MusicSlider(
            position = position,
            duration = duration,
            onSeek = onSeek
        )

        // Playback Controls
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 28.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            IconButton(onClick = { /* TODO: Shuffle logic */ }) {
                Icon(Icons.Outlined.Shuffle, contentDescription = "Shuffle", tint = Color.LightGray)
            }

            IconButton(onClick = { exoPlayer.seekToPrevious() }) {
                Icon(Icons.Default.SkipPrevious, contentDescription = "Previous", tint = Color.White, modifier = Modifier.size(40.dp))
            }

            IconButton(onClick = onPlayPauseToggle) {
                Icon(
                    imageVector = if (isPlaying) Icons.Rounded.PauseCircle else Icons.Rounded.PlayCircle,
                    contentDescription = "Play/Pause",
                    tint = Color.White,
                    modifier = Modifier.size(90.dp)
                )
            }

            IconButton(onClick = { exoPlayer.seekToNext() }) {
                Icon(Icons.Default.SkipNext, contentDescription = "Next", tint = Color.White, modifier = Modifier.size(40.dp))
            }

            IconButton(onClick = { /* Repeat logic */ }) {
                Icon(Icons.Default.Repeat, contentDescription = "Repeat", tint = Color.White)
            }
        }


        Row(modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            SelectionContainer {
                Text("UP NEXT",
                    fontWeight = FontWeight.Bold,
                    color = Color.LightGray,)
            }
            SelectionContainer {
                Text("LYRICS",
                    fontWeight = FontWeight.Bold,
                    color = Color.LightGray,)
            }
            SelectionContainer {
                Text("RELATED",
                    fontWeight = FontWeight.Bold,
                    color = Color.LightGray,)
            }
        }
    }
}
