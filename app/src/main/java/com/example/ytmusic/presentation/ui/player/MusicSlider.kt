package com.example.ytmusic.presentation.ui.player

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MusicSlider(
    position: Long,
    duration: Long,
    onSeek: (Long) -> Unit
) {
    // sliderPosition holds UI slider state (to allow smooth drag)
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    var isUserInteracting by remember { mutableStateOf(false) }

    val ratio = if (duration > 0) position.toFloat() / duration else 0f
    if (!isUserInteracting) {
        sliderPosition = ratio.coerceIn(0f, 1f)
    }

    Column(Modifier.padding(horizontal = 20.dp, vertical = 10.dp)) {
        Slider(
            value = sliderPosition,
            onValueChange = {
                sliderPosition = it
                isUserInteracting = true
            },
            onValueChangeFinished = {
                onSeek((sliderPosition * duration).toLong())
                isUserInteracting = false
            },
            valueRange = 0f..1f,
            colors = SliderDefaults.colors(
                activeTrackColor = Color.White,
                thumbColor = Color.White,
                inactiveTrackColor = Color.Gray
            )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = formatTime(position),
                color = Color.LightGray
            )
            Text(
                text = formatTime(duration),
                color = Color.LightGray
            )
        }
    }
}

fun formatTime(milliseconds: Long): String {
    val totalSeconds = milliseconds / 1000
    val minutes = totalSeconds / 60
    val seconds = totalSeconds % 60
    return "%d:%02d".format(minutes, seconds)
}
