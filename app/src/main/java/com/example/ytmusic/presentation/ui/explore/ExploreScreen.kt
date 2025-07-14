package com.example.ytmusic.presentation.ui.explore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.AutoGraph
import androidx.compose.material.icons.filled.EmojiEmotions
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Podcasts
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun ExploreScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Top row
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ExploreItem(
                icon = Icons.Default.MusicNote,
                label = "New releases",
                modifier = Modifier.weight(1f)
            )
            ExploreItem(
                icon = Icons.Default.AutoGraph,
                label = "Charts",
                modifier = Modifier.weight(1f)
            )
        }

        // Bottom row
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ExploreItem(
                icon = Icons.Default.EmojiEmotions,
                label = "Moods and genres",
                modifier = Modifier.weight(1f)
            )
            ExploreItem(
                icon = Icons.Default.Podcasts,
                label = "Podcasts",
                modifier = Modifier.weight(1f)
            )
        }

ExploreAblum()

    }
}

@Composable
fun ExploreItem(
    icon: ImageVector,
    label: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(120.dp) // consistent height
            .background(Color(0xFF1C1C1C), shape = RoundedCornerShape(8.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = Color.White,
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = label,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}
