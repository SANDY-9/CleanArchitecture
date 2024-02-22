package com.example.blogapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.blogapp.navigation.NavigationItem
import com.example.blogapp.screens.home.HomeScreen
import com.example.blogapp.ui.theme.BlogAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlogAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    MyApp {
                        NavHost(
                            navController = navController,
                            startDestination = NavigationItem.Home.route
                        ) {
                            composable(NavigationItem.Home.route) {
                                HomeScreen(navController)
                            }
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable ()-> Unit) {
    content()
}

