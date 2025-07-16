
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Repeat
import androidx.compose.material.icons.filled.SkipNext
import androidx.compose.material.icons.filled.SkipPrevious
import androidx.compose.material.icons.outlined.Shuffle
import androidx.compose.material.icons.outlined.ThumbDown
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material.icons.rounded.PauseCircle
import androidx.compose.material.icons.rounded.PlayCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage
import com.example.ytmusic.presentation.ui.player.MusicSlider
import androidx.media3.exoplayer.ExoPlayer
import com.example.ytmusic.presentation.ui.player.ExoPlayerViewModel


@Composable
fun SongPreview(
    viewModel: ExoPlayerViewModel,
    onPlayPauseToggle: () -> Unit,
    onSeek: (Long) -> Unit
) {
    val exoPlayer = viewModel.exoPlayer
    val isPlaying by viewModel.isPlaying.collectAsState()
    val position by viewModel.position.collectAsState()
    val duration by viewModel.duration.collectAsState()

    Column {
        // Album Art
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .padding(horizontal = 30.dp, vertical = 10.dp)
                    .size(300.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = "https://is1-ssl.mzstatic.com/image/thumb/Video126/v4/88/70/e9/8870e976-1d4e-0ed6-d5a1-02cc6183558c/Job3b60a129-8c0d-4179-b6ec-903b71bf1b18-129193526-PreviewImage_preview_image_nonvideo_sdr-Time1645812297481.png/592x592bb.webp",
                    contentDescription = "Song Preview",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

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
