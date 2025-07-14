package com.example.ytmusic.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.ytmusic.presentation.ui.explore.ExploreScreen
import com.example.ytmusic.presentation.ui.home.HomePage
import com.example.ytmusic.presentation.ui.library.LibraryScreen
import com.example.ytmusic.presentation.ui.sample.SampleScreen

// 🔖 Sealed class to define bottom nav items
sealed class BottomNavItem(
    val route: String,
    val icon: ImageVector,
    val label: String
) {
    object Home : BottomNavItem("home", Icons.Default.Home, "Home")
    object Samples : BottomNavItem("samples", Icons.Default.PlayArrow, "Samples")
    object Explore : BottomNavItem("explore", Icons.Default.Explore, "Explore")
    object Library : BottomNavItem("library", Icons.Default.LibraryMusic, "Library")
}

// 🔀 Bottom Navigation Graph
@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route
    ) {
        composable(BottomNavItem.Home.route) {
            HomePage(navController)
        }
        composable(BottomNavItem.Samples.route) {
            SampleScreen(navController)
        }
        composable(BottomNavItem.Explore.route) {
            ExploreScreen(navController)
        }
        composable(BottomNavItem.Library.route) {
            LibraryScreen(navController)
        }
    }
}

// 🎯 Bottom Navigation Bar
@Composable
fun BottomNavBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Samples,
        BottomNavItem.Explore,
        BottomNavItem.Library
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(
        containerColor = Color.Black,
        tonalElevation = 0.dp
    ) {
        items.forEach { item ->
            val selected = currentRoute == item.route

            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label,
                        tint = if (selected) Color.White else Color.Gray
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        color = if (selected) Color.White else Color.Gray
                    )
                },
                selected = selected,
                onClick = {
                    if (!selected) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color(0xFF1A1A1A), // ✅ lighter than black
                    selectedIconColor = Color.White,
                    selectedTextColor = Color.White,
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray
                )
            )
        }
    }
}
