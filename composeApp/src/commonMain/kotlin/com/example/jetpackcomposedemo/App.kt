package com.example.jetpackcomposedemo
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import com.example.jetpackcomposedemo.ui.HomeScreen
import com.example.jetpackcomposedemo.ui.LoginScreen
import com.example.jetpackcomposedemo.ui.SplashScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

// Define screens
sealed class Screen {
    object Splash : Screen()
    object Login : Screen()
    object Home : Screen()
}

@Composable
@Preview
fun App() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Splash) }

    MaterialTheme {
        when (currentScreen) {
            is Screen.Splash -> SplashScreen {
                currentScreen = Screen.Login
            }
            is Screen.Login -> LoginScreen {
                currentScreen = Screen.Home
            }
            is Screen.Home -> HomeScreen()
        }
    }
}
