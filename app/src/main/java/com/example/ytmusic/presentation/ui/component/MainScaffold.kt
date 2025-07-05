package com.example.ytmusic.presentation.ui.component

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavHostController
import com.example.ytmusic.R
import com.example.ytmusic.presentation.navigation.BottomNavBar
import com.example.ytmusic.presentation.navigation.BottomNavGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(navController: NavHostController) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    // 🧠 Set up system UI (black status/nav bars)
    val view = LocalView.current
    val context = LocalContext.current
    SideEffect {
        val window = (context as Activity).window
        window.statusBarColor = android.graphics.Color.BLACK
        window.navigationBarColor = android.graphics.Color.BLACK

        val insetsController = WindowInsetsControllerCompat(window, view)
        insetsController.isAppearanceLightStatusBars = false
        insetsController.isAppearanceLightNavigationBars = false
    }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        containerColor = Color.Black,
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = "YouTube Music Logo",
                            modifier = Modifier.size(80.dp)
                        )
                    }
                },
                actions = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        IconButton(onClick = { /* do something */ }) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = "More options",
                                tint = Color.White
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black,
                    scrolledContainerColor = Color.Black,
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White
                ),
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = {
            BottomNavBar(navController = navController)
        }
    ) { innerPadding ->
        // This is where the magic happens 🎩✨
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.Black)
        ) {
            BottomNavGraph(navController = navController)
        }
    }
}
