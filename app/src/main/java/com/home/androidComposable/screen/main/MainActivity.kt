package com.home.androidComposable.screen.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.home.androidComposable.ui.theme.MovieTheme

// 1. Composable function: Text, Image...
// 2. Layout: Column, Row, Modifier.
// 3. Material Design has 2 main: Color (Màu), Typography (Kiểu chữ) và Shape
// 4. Lists and Animation

// Unit: Lists and animations are everywhere in apps.
// In this lesson, you will learn how Compose makes it easy to create lists and fun to add animations. and register events
class MainActivity : ComponentActivity() {
    //https://medium.com/@KaushalVasava/navigation-in-jetpack-compose-full-guide-beginner-to-advanced-950c1133740
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieTheme {
                val navController = rememberNavController()
                val newBackStackEntry by navController.currentBackStackEntryAsState()
                val route = newBackStackEntry?.destination?.route
                MainScreen(navController)
            }
        }
    }
}