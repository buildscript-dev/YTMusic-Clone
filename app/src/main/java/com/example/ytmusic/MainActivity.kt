package com.example.ytmusic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import com.example.ytmusic.presentation.ui.component.MainScaffold
import com.example.ytmusic.presentation.ui.player.PlayerScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()

            MaterialTheme {
                Surface {
                    MainScaffold(navController = navController)
//                    PlayerScreen(navController= navController)
                }
            }
        }
    }
}