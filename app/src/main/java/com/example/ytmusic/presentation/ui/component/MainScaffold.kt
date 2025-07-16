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
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.ytmusic.R
import com.example.ytmusic.presentation.navigation.BottomNavBar
import com.example.ytmusic.presentation.navigation.BottomNavGraph
import com.example.ytmusic.presentation.ui.player.PlayerScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(navController: NavHostController) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    val navBackStackEntry = navController.currentBackStackEntryAsState().value
    val currentRoute = navBackStackEntry?.destination?.route

    val showBottomBarRoutes = listOf("home", "samples", "explore", "library")
    val showBottomBar = currentRoute in showBottomBarRoutes
    val showTopBar = currentRoute !in listOf("player")

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
        modifier = Modifier
            .fillMaxSize()
            .then(if (showTopBar) Modifier.nestedScroll(scrollBehavior.nestedScrollConnection) else Modifier),
        containerColor = Color.Black,
        topBar = if (showTopBar) {
            {
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
                        IconButton(onClick = { /* do stuff */ }) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = "More options",
                                tint = Color.White
                            )
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
            }
        } else {
            {
                PlayerScreen(navController = navController)
            }
        },
        bottomBar = {
            if (showBottomBar) {
                BottomNavBar(navController = navController)
            }
        }
    ) { innerPadding ->
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
