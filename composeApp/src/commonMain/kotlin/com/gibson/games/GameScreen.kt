package com.gibson.games

import androidx.compose.runtime.Composable
import androidx.activity.compose.BackHandler
import com.gibson.games.ludo.LudoGameScreen
import com.gibson.games.ludo.LudoMainMenuScreen
import com.gibson.games.ludo.LudoSettingsScreen
import com.gibson.games.Game
import androidx.compose.runtime.*

/**
 * A wrapper screen for the selected game. It handles the top-level back navigation.
 */
@Composable
fun GameScreen(game: Game, onExit: () -> Unit) {
    when (game) {
        Game.LUDO -> LudoNavigationScreen(onExit = onExit)
        // Add other games here
    }
}

/**
 * Navigation controller for Ludo game screens
 */
@Composable
fun LudoNavigationScreen(onExit: () -> Unit) {
    var currentScreen by remember { mutableStateOf("main_menu") }
    
    // BackHandler for returning from Ludo main menu to game selection
    if (currentScreen == "main_menu") {
        BackHandler {
            onExit()
        }
    }
    
    when (currentScreen) {
        "main_menu" -> LudoMainMenuScreen(
            onPlayClicked = { currentScreen = "game" },
            onExitClicked = { onExit() },
            onSettingsClicked = { currentScreen = "settings" }
        )
        "game" -> LudoGameScreen(
            onExit = { currentScreen = "main_menu" }
        )
        "settings" -> LudoSettingsScreen(
            onBackClicked = { currentScreen = "main_menu" }
        )
    }
}
