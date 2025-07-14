package com.example.ytmusic.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// 1. Data class
data class Category(val name: String)

// 2. Sample category list
val categories = listOf(
    Category("Podcasts"),
    Category("Relax"),
    Category("Romance"),
    Category("Workout"),
    Category("Feel good"),
    Category("Party"),
    Category("Energies"),
    Category("Commute"),
    Category("Sad"),
    Category("Focus"),
    Category("Sleep")
)

// 3. Composable function
@Composable
fun CategoryView() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
        contentPadding = PaddingValues(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories) { category ->
            Card(
                modifier = Modifier.wrapContentWidth()
                    .border(1.dp, Color.DarkGray, RoundedCornerShape(8.dp)),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent.copy(alpha = 0.1f)
                ),
                elevation = CardDefaults.cardElevation(0.dp)
            ) {
                Text(
                    text = category.name,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .background(Color.Gray.copy(alpha = 0.3f))
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
