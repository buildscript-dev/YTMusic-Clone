package com.example.ytmusic.presentation.ui.player

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.example.ytmusic.data.remote.SongItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ExoPlayerViewModel(app: Application) : AndroidViewModel(app) {

    private val context = app.applicationContext

    val exoPlayer: ExoPlayer = ExoPlayer.Builder(context).build()

    private val _position = MutableStateFlow(0L)
    val position = _position.asStateFlow()

    private val _duration = MutableStateFlow(0L)
    val duration = _duration.asStateFlow()

    private val _isPlaying = MutableStateFlow(false)
    val isPlaying = _isPlaying.asStateFlow()

    private val _currentSong = MutableStateFlow<SongItem?>(null)
    val currentSong = _currentSong.asStateFlow()

    init {
        viewModelScope.launch {
            while (true) {
                _position.value = exoPlayer.currentPosition
                _duration.value = exoPlayer.duration
                _isPlaying.value = exoPlayer.isPlaying
                delay(500L)
            }
        }
    }

    fun loadSong(song: SongItem) {
        _currentSong.value = song

        song.audioUrl?.let { url ->
            val uri = Uri.parse(url)
            val mediaItem = MediaItem.fromUri(uri)
            exoPlayer.setMediaItem(mediaItem)
            exoPlayer.prepare()
        }
    }

    fun play() {
        exoPlayer.play()
        _isPlaying.value = true
    }

    fun pause() {
        exoPlayer.pause()
        _isPlaying.value = false
    }

    fun seekTo(pos: Long) {
        exoPlayer.seekTo(pos)
    }

    override fun onCleared() {
        super.onCleared()
        exoPlayer.release()
    }
}
