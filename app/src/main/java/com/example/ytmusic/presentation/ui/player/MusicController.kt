package com.example.ytmusic.presentation.ui.player

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.rounded.*

import androidx.media3.exoplayer.ExoPlayer

@Composable
fun MusicController(
    exoPlayer: ExoPlayer,
    switchedMedium: Boolean,
    switchController: Boolean
) {
    if (!switchController || !switchedMedium) return

    var isPlaying by remember { mutableStateOf(exoPlayer.isPlaying) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        IconButton(onClick = {
            // Shuffle logic (not implemented yet)
        }) {
            Icon(
                imageVector = Icons.Outlined.Shuffle,
                contentDescription = "Shuffle",
                tint = Color.LightGray
            )
        }

        IconButton(onClick = {
            exoPlayer.seekToPrevious()
        }) {
            Icon(
                imageVector = Icons.Default.SkipPrevious,
                contentDescription = "Previous",
                tint = Color.White,
                modifier = Modifier.size(40.dp)
            )
        }

        IconButton(onClick = {
            if (exoPlayer.isPlaying) {
                exoPlayer.pause()
                isPlaying = false
            } else {
                exoPlayer.play()
                isPlaying = true
            }
        }) {
            Icon(
                imageVector = if (isPlaying) Icons.Rounded.PauseCircle else Icons.Rounded.PlayCircle,
                contentDescription = "Play/Pause",
                tint = Color.White,
                modifier = Modifier.size(90.dp)
            )
        }

        IconButton(onClick = {
            exoPlayer.seekToNext()
        }) {
            Icon(
                imageVector = Icons.Default.SkipNext,
                contentDescription = "Next",
                tint = Color.White,
                modifier = Modifier.size(40.dp)
            )
        }

        IconButton(onClick = {
            exoPlayer.repeatMode =
                if (exoPlayer.repeatMode == ExoPlayer.REPEAT_MODE_ONE) {
                    ExoPlayer.REPEAT_MODE_OFF
                } else {
                    ExoPlayer.REPEAT_MODE_ONE
                }
        }) {
            Icon(
                imageVector = Icons.Default.Repeat,
                contentDescription = "Repeat",
                tint = if (exoPlayer.repeatMode == ExoPlayer.REPEAT_MODE_ONE) Color.White else Color.LightGray
            )
        }
    }
}
