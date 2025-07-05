package com.example.ytmusic.presentation.ui.sample

import android.content.Context
import android.net.Uri
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

@Composable
fun VideoPlayer(
    context: Context,
    videoUri: String,
    modifier: Modifier = Modifier,
    showControls: Boolean = false,
    autoPlay: Boolean = true
) {
    // Track play state to toggle on double-tap
    var isPlaying by remember { mutableStateOf(autoPlay) }

    val exoPlayer = remember(videoUri) {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(Uri.parse(videoUri)))
            prepare()
            playWhenReady = isPlaying
        }
    }

    // Sync play/pause state if toggled
    LaunchedEffect(isPlaying) {
        exoPlayer.playWhenReady = isPlaying
    }

    DisposableEffect(videoUri) {
        onDispose {
            exoPlayer.release()
        }
    }

    // Box to detect double taps over the video
    Box(
        modifier = modifier.pointerInput(Unit) {
            detectTapGestures(
                onDoubleTap = {
                    isPlaying = !isPlaying // Toggle play/pause
                }
            )
        }
    ) {
        AndroidView(
            factory = {
                PlayerView(context).apply {
                    player = exoPlayer
                    useController = showControls
                }
            },
            modifier = Modifier.matchParentSize()
        )
    }
}
