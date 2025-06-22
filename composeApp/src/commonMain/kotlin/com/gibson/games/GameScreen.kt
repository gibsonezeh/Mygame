package com.gibson.games

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * A wrapper screen for the selected game. It handles the top-level back navigation.
 */
@Composable
fun GameScreen(game: Game, onExit: () -> Unit) {
    when (game) {
        Game.LUDO -> {LudoNavigationScreen(onExit = onExit)}

        Game.CHECKERS -> PlaceholderScreen("Checkers" , onExit)/* TODO: Implement Checkers Screen */


        Game.SNAKE -> PlaceholderScreen("Snake" , onExit) /* TODO: Implement Snake Screen */


        Game.CHESS -> PlaceholderScreen("Chess", onExit) /* TODO: Implement Chess Screen */


        Game.TIC_TAC_TOE -> PlaceholderScreen("Tic Tac Toe", onExit) /* TODO: Implement TicTacToe Screen */

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
    BackHandler(currentScreen == "ludo_game") {
        currentScreen = "main_menu"
        onExit()
    }

    when (currentScreen) {
        "main_menu" -> {
            LudoMainMenu(onPlay = { currentScreen = "ludo_game" })
        }
   "ludo_game" -> LudoGameScreen(onExit = {currentScreen = "main_menu"
   })

    }
}

@Composable
fun PlaceholderScreen(title: String, onExit: () -> Unit){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("$title coming soon", style =
            MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onExit) {
            Text("Exit")
        }
    }
}

